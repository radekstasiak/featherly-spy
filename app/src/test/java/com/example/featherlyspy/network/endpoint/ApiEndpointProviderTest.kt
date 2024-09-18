package com.example.featherlyspy.network.endpoint

import android.content.Context
import com.example.featherlyspy.R
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ApiEndpointProviderTest {


    private val context = mockk<Context>()
    private val sut: ApiEndpointProvider by lazy {
        ApiEndpointProvider(
            context = context
        )
    }

    private val ebirdEndpointMock = "ebird endpoint"
    private val nuthatchEndpointMock = "nuthatch endpoint"

    @Before
    fun setup() {
        every { context.resources.getString(R.string.ebird_api_endpoint) } returns ebirdEndpointMock
        every { context.resources.getString(R.string.nuthatch_api_endpoint) } returns nuthatchEndpointMock
    }

    @Test
    fun `WHEN ebird api endpoint requested THEN returns ebird api endpoint resource`() {
        val result = sut.eBirdApiEndpoint
        assertEquals(ebirdEndpointMock, result)
    }

    @Test
    fun `WHEN nuthatch api endpoint requested THEN returns nuthatch api endpoint resource`() {
        val result = sut.nuthatchEndpoint
        assertEquals(nuthatchEndpointMock, result)
    }
}
