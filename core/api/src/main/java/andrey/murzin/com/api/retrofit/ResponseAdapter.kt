package andrey.murzin.com.api.retrofit

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type
import andrey.murzin.com.api.base.Result

class ResponseAdapter<R>(private val type: Type) : CallAdapter<R, Call<Result<R>>> {

    override fun responseType(): Type = type

    override fun adapt(call: Call<R>): Call<Result<R>> = ResultCall(call)
}
