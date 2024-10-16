package com.example.featherlyspy.network.api

import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.example.featherlyspy.network.model.ApiError
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EBirdApiService {

    @GET("/v2/data/obs/geo/recent")
    suspend fun getRecentNearbyObservations(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double
    ): NetworkResponse<List<RecentNearbyObsApiModel>, ApiError>
}
