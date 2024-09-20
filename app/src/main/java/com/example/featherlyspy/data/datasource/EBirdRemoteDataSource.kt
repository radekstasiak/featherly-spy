package com.example.featherlyspy.data.datasource

import com.example.featherlyspy.network.api.EBirdApiService
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.example.featherlyspy.network.model.NetworkError
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class EBirdRemoteDataSource @Inject constructor(
    private val api: EBirdApiService
) : EBirdDataSource {

    override suspend fun getRecentNearbyObservations(
        lat: Double,
        lng: Double
    ): NetworkResponse<List<RecentNearbyObsApiModel>, NetworkError> =
        api.getRecentNearbyObservations(
            lat = lat,
            lng = lng
        )
}
