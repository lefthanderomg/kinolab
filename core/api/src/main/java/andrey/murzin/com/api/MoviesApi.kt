package andrey.murzin.com.api

import andrey.murzin.com.api.base.Result
import andrey.murzin.com.api.model.MoviePageModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/top_rated")
    suspend fun getTopRated(
       @Query("page") page: Int
    ) : Result<MoviePageModel>
}
