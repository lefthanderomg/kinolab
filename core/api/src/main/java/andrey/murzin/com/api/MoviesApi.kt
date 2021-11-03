package andrey.murzin.com.api

import andrey.murzin.com.api.base.Result
import andrey.murzin.com.api.model.MoviePageModel
import retrofit2.http.GET

interface MoviesApi {

    @GET("movie/top_rated?api_key=2da3bfb8f2010c50ca19ab4e13c29f17&language=en-US&page=1")
    suspend fun getTopRated() : Result<MoviePageModel>
}