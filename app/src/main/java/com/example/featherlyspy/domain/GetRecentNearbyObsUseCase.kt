package com.example.featherlyspy.domain

import com.example.featherlyspy.data.repository.EBirdRepository
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class GetRecentNearbyObsUseCase @Inject constructor(
    private val repository: EBirdRepository
) {

    suspend operator fun invoke(
        lat: Double,
        lng: Double
    ) {
        when (repository.getRecentNearbyObservations(
            lat = lat,
            lng = lng
        )) {
            is NetworkResponse.Success -> TODO()
            is NetworkResponse.Error -> TODO()
        }
    }
}
