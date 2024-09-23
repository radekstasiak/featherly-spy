package com.example.featherlyspy.data.datasource

import com.example.featherlyspy.network.api.EBirdApiService
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.example.featherlyspy.network.model.ApiError
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class EBirdRemoteDataSource @Inject constructor(
    private val api: EBirdApiService
) : EBirdDataSource {

    override suspend fun getRecentNearbyObservations(
        lat: Double,
        lng: Double
    ): NetworkResponse<List<RecentNearbyObsApiModel>, ApiError> =
        api.getRecentNearbyObservations(
            lat = lat,
            lng = lng
        )
}
