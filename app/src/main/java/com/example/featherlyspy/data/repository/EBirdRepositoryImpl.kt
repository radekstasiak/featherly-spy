package com.example.featherlyspy.data.repository

import com.example.featherlyspy.data.datasource.EBirdRemoteDataSource
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.example.featherlyspy.network.model.RestError
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class EBirdRepositoryImpl @Inject constructor(
    private val dataSource: EBirdRemoteDataSource
) : EBirdRepository {

    override suspend fun getRecentNearbyObservations(
        lat: Double,
        lng: Double
    ): NetworkResponse<List<RecentNearbyObsApiModel>, RestError> =
        dataSource.getRecentNearbyObservations(
            lat = lat,
            lng = lng
        )
}
