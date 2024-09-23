package com.example.featherlyspy.domain.recentnearbyobs

import com.example.featherlyspy.data.repository.EBirdRepository
import com.example.featherlyspy.domain.base.DomainError
import com.example.featherlyspy.domain.base.DomainErrorMapper
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok

import com.github.michaelbull.result.Result
import com.github.michaelbull.result.fold
import javax.inject.Inject

class GetRecentNearbyObsUseCase @Inject constructor(
    private val repository: EBirdRepository,
    private val mapper: RecentNearbyObsModelMapper,
    private val errorMapper: DomainErrorMapper
) {

    suspend operator fun invoke(
        lat: Double,
        lng: Double
    ): Result<List<RecentNearbyObsModel>, DomainError> =
        repository.getRecentNearbyObservations(
            lat = lat,
            lng = lng
        ).fold(
            { success -> Ok(mapper.toDomain(success)) },
            { error -> Err(errorMapper.toDomain(error)) }
        )
}
