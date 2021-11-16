package andrey.murzin.com.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(
    private val apiKey: String
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url.newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()

        val request = chain.request().newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(request)
    }
}
