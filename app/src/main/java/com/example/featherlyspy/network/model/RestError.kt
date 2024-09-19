package com.example.featherlyspy.network.model

import com.squareup.moshi.Json

data class RestError(
    @Json(name = "errors") val errors: List<ErrorDetails>
) {
    data class ErrorDetails(
        @Json(name = "status") val status: String,
        @Json(name = "code") val code: String,
        @Json(name = "title") val title: String,
    )
}

