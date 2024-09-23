package com.example.featherlyspy.data.datasource

import com.example.featherlyspy.network.api.EBirdApiService
import com.example.featherlyspy.network.model.ApiError
import com.example.featherlyspy.network.model.RecentNearbyObsApiModel
import com.haroldadmin.cnradapter.NetworkResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class EBirdRemoteDataSourceTest {

    private val api = mockk<EBirdApiService>()

    private val sut: EBirdRemoteDataSource by lazy {
        EBirdRemoteDataSource(
            api = api
        )
    }

    @Test
    fun `WHEN get recent nearby obs returns success THEN return Network Response`() = runTest {
        val response = mockk<NetworkResponse.Success<List<RecentNearbyObsApiModel>, ApiError>>()

        coEvery {
            api.getRecentNearbyObservations(

                lat = 1.0,
                lng = 2.0
            )
        } returns response

        val result = sut.getRecentNearbyObservations(
            lat = 1.0,
            lng = 2.0
        )

        assertTrue(result is NetworkResponse.Success)
    }

    @Test
    fun `WHEN get recent nearby obs returns error THEN return Network Response`() = runTest {
        val response = mockk<NetworkResponse.Error<List<RecentNearbyObsApiModel>, ApiError>>()

        coEvery {
            api.getRecentNearbyObservations(

                lat = 1.0,
                lng = 2.0
            )
        } returns response

        val result = sut.getRecentNearbyObservations(
            lat = 1.0,
            lng = 2.0
        )

        assertTrue(result is NetworkResponse.Error)
    }
}
