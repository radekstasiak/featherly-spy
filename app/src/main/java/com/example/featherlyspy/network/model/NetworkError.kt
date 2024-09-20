package com.example.featherlyspy.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkError(
    @Json(name = "errors") val errors: List<ErrorDetails>
) {
    @JsonClass(generateAdapter = true)
    data class ErrorDetails(
        @Json(name = "status") val status: String,
        @Json(name = "code") val code: String,
        @Json(name = "title") val title: String,
    )
}

