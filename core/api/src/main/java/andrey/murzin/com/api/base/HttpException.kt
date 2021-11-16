package andrey.murzin.com.api.base

class HttpException(
    val code: Int,
    override val message: String? = null,
    val url: String? = null,
    override val cause: Throwable? = null
) : Exception(cause)
