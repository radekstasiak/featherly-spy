package com.example.featherlyspy.data.repository

import com.example.featherlyspy.data.repository.model.RepositoryError
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.github.michaelbull.result.Result

interface EBirdRepository {

    suspend fun getRecentNearbyObservations(
        lat: Double,
        lng: Double
    ): Result<List<RecentNearbyObsApiModel>, RepositoryError>
}
