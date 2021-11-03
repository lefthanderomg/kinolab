package andrey.murzin.com.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MoviePageModel(
    @SerialName("page") val page: Int
)