package andrey.murzin.com.api

import andrey.murzin.com.api.base.Result
import andrey.murzin.com.api.model.MoviePageModel
import retrofit2.http.GET

interface MoviesApi {

    @GET("movie/top_rated")
    suspend fun getTopRated() : Result<MoviePageModel>
}