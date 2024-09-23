package com.example.featherlyspy.domain

import com.example.featherlyspy.data.repository.EBirdRepository
import com.example.featherlyspy.data.repository.model.RepositoryError
import com.example.featherlyspy.domain.base.DomainError
import com.example.featherlyspy.domain.base.DomainErrorMapper
import com.example.featherlyspy.domain.recentnearbyobs.GetRecentNearbyObsUseCase
import com.example.featherlyspy.domain.recentnearbyobs.RecentNearbyObsModel
import com.example.featherlyspy.domain.recentnearbyobs.RecentNearbyObsModelMapper
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GetRecentNearbyObsUseCaseTest {

    private val repository = mockk<EBirdRepository>()
    private val mapper = mockk<RecentNearbyObsModelMapper>()
    private val errorMapper = mockk<DomainErrorMapper>()

    private val sut: GetRecentNearbyObsUseCase by lazy {
        GetRecentNearbyObsUseCase(
            mapper = mapper,
            repository = repository,
            errorMapper = errorMapper
        )
    }

    @Test
    fun `WHEN repository returns list of models THEN return Ok result`() = runTest {
        val recentNearbyObsApiModelList = listOf<RecentNearbyObsApiModel>(mockk())
        val recentNearbyObsModelList = listOf<RecentNearbyObsModel>(mockk())
        coEvery {
            repository.getRecentNearbyObservations(
                lat = 1.0,
                lng = 2.0
            )
        } returns Ok(recentNearbyObsApiModelList)

        every { mapper.toDomain(recentNearbyObsApiModelList) } returns recentNearbyObsModelList

        val result = sut(
            lat = 1.0,
            lng = 2.0
        )

        assertEquals(recentNearbyObsModelList, result.value)
    }

    @Test
    fun `WHEN repository returns repository error THEN return Err result`() = runTest {
        val repositoryError = mockk<RepositoryError>()
        val domainError = mockk<DomainError>()

        coEvery {
            repository.getRecentNearbyObservations(
                lat = 1.0,
                lng = 2.0
            )
        } returns Err(repositoryError)

        every { errorMapper.toDomain(repositoryError) } returns domainError

        val result = sut(
            lat = 1.0,
            lng = 2.0
        )

        assertEquals(domainError, result.error)
    }
}
