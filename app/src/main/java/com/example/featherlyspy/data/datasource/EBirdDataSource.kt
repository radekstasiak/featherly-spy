package com.example.featherlyspy.data.datasource

import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.example.featherlyspy.network.model.ApiError
import com.haroldadmin.cnradapter.NetworkResponse

interface EBirdDataSource {

    suspend fun getRecentNearbyObservations(
        lat: Double,
        lng: Double
    ): NetworkResponse<List<RecentNearbyObsApiModel>, ApiError>
}
