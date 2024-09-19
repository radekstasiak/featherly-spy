package com.example.featherlyspy.data.repository

import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.example.featherlyspy.network.model.RestError
import com.haroldadmin.cnradapter.NetworkResponse

interface EBirdRepository {

    suspend fun getRecentNearbyObservations(
        lat: Double,
        lng: Double
    ): NetworkResponse<List<RecentNearbyObsApiModel>, RestError>
}
