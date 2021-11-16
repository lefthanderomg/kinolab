package andrey.murzin.com.api.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class LanguageInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val newUrl = chain.request().url.newBuilder()
            .addQueryParameter("language", language())
            .build()

        val request = chain.request().newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(request)
    }

    private fun language(): String = Locale.US.run {
        "${language}-${country}"
    }
}
