package andrey.murzin.com.api.retrofit

import andrey.murzin.com.api.base.HttpException
import andrey.murzin.com.api.base.Result
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultCall<T>(private val proxy: Call<T>) : Call<Result<T>> {

    override fun enqueue(callback: Callback<Result<T>>) {
        proxy.enqueue(ResultCallback(this, callback))
    }

    override fun clone(): Call<Result<T>> = ResultCall(proxy.clone())

    override fun request(): Request = proxy.request()

    override fun timeout(): Timeout = proxy.timeout()

    override fun isExecuted(): Boolean = proxy.isExecuted

    override fun cancel() = proxy.cancel()

    override fun isCanceled(): Boolean = proxy.isCanceled

    override fun execute(): Response<Result<T>> = throw NotImplementedError()

    private class ResultCallback<T>(
        private val proxy: ResultCall<T>,
        private val callback: Callback<Result<T>>
    ) : Callback<T> {

        override fun onResponse(call: Call<T>, response: Response<T>) {
            val result: Result<T> = if (response.isSuccessful) {
                Result.Success.HttpResponse<T>(
                    value = response.body()!!,
                    code = response.code(),
                    message = response.message(),
                    url = call.url()
                )
            } else {
                Result.Fail.HttpError(
                    error = HttpException(
                        code = response.code(),
                        message = response.message(),
                        url = call.url(),
                    )
                )
            }

            callback.onResponse(proxy, Response.success(result))
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            val result = when (throwable) {
                is retrofit2.HttpException -> {
                    Result.Fail.HttpError(
                        HttpException(
                            code = throwable.code(),
                            message = throwable.message(),
                            url = call.url(),
                            cause = throwable,
                        )
                    )
                }
                else -> Result.Fail.Error(throwable)
            }

            callback.onResponse(proxy, Response.success(result))
        }
    }
}

private fun <T> Call<T>.url() = request().url.toString()
