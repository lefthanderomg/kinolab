package andrey.murzin.com.api

import andrey.murzin.com.api.interceptor.ApiKeyInterceptor
import andrey.murzin.com.api.interceptor.LanguageInterceptor
import andrey.murzin.com.api.retrofit.ResultAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create

const val BASE_URL = "https://api.themoviedb.org/3/"

private val json = Json { ignoreUnknownKeys = true }

private fun loggingInterceptor() = HttpLoggingInterceptor().apply {
    setLevel(HttpLoggingInterceptor.Level.BASIC)
}

@ExperimentalSerializationApi
fun converterJsonFactory() =
    json.asConverterFactory("application/json".toMediaType())

fun okHttpClient(apiKey: String) = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor())
    .addInterceptor(ApiKeyInterceptor(apiKey))
    .addInterceptor(LanguageInterceptor())
    .build()

@ExperimentalSerializationApi
inline fun <reified T> createApi(apiKey: String) = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(okHttpClient(apiKey))
    .addCallAdapterFactory(ResultAdapterFactory())
    .addConverterFactory(converterJsonFactory())
    .build()
    .create<T>()
