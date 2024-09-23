package com.example.featherlyspy.data.repository

import com.example.featherlyspy.data.datasource.EBirdDataSource
import com.example.featherlyspy.data.repository.mapper.toErr
import com.example.featherlyspy.data.repository.model.RepositoryError
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.example.featherlyspy.network.model.ApiError
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.fold
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class EBirdRepositoryImpl @Inject constructor(
    private val dataSource: EBirdDataSource
) : EBirdRepository {

    override suspend fun getRecentNearbyObservations(
        lat: Double,
        lng: Double
    ): Result<List<RecentNearbyObsApiModel>, RepositoryError> =
        when (
            val result = dataSource.getRecentNearbyObservations(
                lat = lat,
                lng = lng
            )
        ) {
            is NetworkResponse.Success -> Ok(result.body)
            is NetworkResponse.Error -> result.toErr()
        }
}
