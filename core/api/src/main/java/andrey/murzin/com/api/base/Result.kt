package andrey.murzin.com.api.base


sealed class Result<out T> {

    sealed class Success<T>(open val value: T) : Result<T>() {

        class Value<T>(override val value: T) : Success<T>(value)

        class HttpResponse<T>(
            override val value: T,
            val code: Int,
            val message: String? = null,
            val url: String? = null
        ) : Success<T>(value)

        class Empty(override val value: Nothing) : Success<Nothing>(value)
    }

    sealed class Fail<E : Throwable>(open val error: E? = null) : Result<Nothing>() {

        class Error(override val error: Throwable) : Fail<Throwable>(error)

        class HttpError(override val error: HttpException) : Fail<HttpException>(error)
    }
}
