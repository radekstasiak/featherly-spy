package com.example.featherlyspy.data.repository

import com.example.featherlyspy.data.datasource.EBirdDataSource
import com.example.featherlyspy.data.repository.mapper.toErr
import com.example.featherlyspy.data.repository.model.RepositoryError
import com.example.featherlyspy.network.model.ApiError
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.github.michaelbull.result.Err
import com.haroldadmin.cnradapter.NetworkResponse
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class EBirdRepositoryTest {

    private val dataSource = mockk<EBirdDataSource>()

    private val sut: EBirdRepository by lazy {
        EBirdRepositoryImpl(
            dataSource = dataSource
        )
    }

    @Before
    fun setup() {
        mockkStatic("com.example.featherlyspy.data.repository.mapper.NetworkErrorMapperKt")
    }

    @Test
    fun `WHEN Network Response success THEN returns Ok result `() = runTest {
        val recentNearbyObsApiModels = listOf<RecentNearbyObsApiModel>(
            mockk(),
            mockk()
        )
        val response = mockk<NetworkResponse.Success<List<RecentNearbyObsApiModel>, ApiError>>() {
            every { body } returns recentNearbyObsApiModels
        }

        coEvery {
            dataSource.getRecentNearbyObservations(
                lat = 1.0,
                lng = 2.0
            )
        } returns response


        val result = sut.getRecentNearbyObservations(
            lat = 1.0,
            lng = 2.0
        )

        assertTrue(result.isOk)
        assertEquals(recentNearbyObsApiModels, result.value)

    }

    @Test
    fun `WHEN Network Response success THEN returns mapped error `() = runTest {
        val repositoryError = mockk<RepositoryError>()
        val response = mockk<NetworkResponse.ServerError<List<RecentNearbyObsApiModel>, ApiError>>()

        coEvery {
            dataSource.getRecentNearbyObservations(
                lat = 1.0,
                lng = 2.0
            )
        } returns response

        every { response.toErr() } returns Err(repositoryError)

        val result = sut.getRecentNearbyObservations(
            lat = 1.0,
            lng = 2.0
        )

        assertTrue(result.isErr)
        assertEquals(repositoryError, result.error)

    }
}
