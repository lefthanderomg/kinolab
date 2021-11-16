
package andrey.murzin.com.kinolab

import andrey.murzin.com.api.MoviesApi
import andrey.murzin.com.api.createApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiKey() = BuildConfig.THEMOVIEDB_API_KEY

    @Suppress("EXPERIMENTAL_API_USAGE")
    @Singleton
    @Provides
    fun provideMovieApi(apiKey: String) : MoviesApi = createApi(apiKey)

}
