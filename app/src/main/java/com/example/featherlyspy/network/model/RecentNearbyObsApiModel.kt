package com.example.featherlyspy.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RecentNearbyObsApiModel(
    @Json(name = "speciesCode") val speciesCode: String,
    @Json(name = "comName") val comName: String,
    @Json(name = "sciName") val sciName: String,
    @Json(name = "locId") val locId: String,
    @Json(name = "obsDt") val obsDt: String,
    @Json(name = "lat") val lat: Double,
    @Json(name = "lng") val lng: Double,
    @Json(name = "obsValid") val obsValid: Boolean,
    @Json(name = "obsReviewed") val obsReviewed: Boolean,
    @Json(name = "locationPrivate") val locationPrivate: Boolean,
    @Json(name = "subId") val subId: String,
    @Json(name = "exoticCategory") val exoticCategory: String
)
