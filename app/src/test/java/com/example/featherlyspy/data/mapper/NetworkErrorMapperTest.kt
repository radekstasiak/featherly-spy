package com.example.featherlyspy.data.mapper

import com.example.featherlyspy.data.repository.mapper.toErr
import com.example.featherlyspy.data.repository.mapper.toNetworkError
import com.example.featherlyspy.network.model.ApiError
import com.haroldadmin.cnradapter.NetworkResponse
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import okio.IOException

import org.junit.Test

class NetworkErrorMapperTest {

    @Test
    fun `WHEN server error with errors list THEN return repository error`() {
        val error = Throwable(
            message = "error message"
        )
        val apiError = ApiError(
            errors = listOf(
                ApiError.ErrorDetails(
                    code = "error.data.lat_required",
                    status = "400 BAD_REQUEST",
                    title = "title 1"
                ),
                ApiError.ErrorDetails(
                    code = "error.data.lng_required",
                    status = "422 BAD_REQUEST",
                    title = "title 2"
                )
            )
        )
        val networkResponse = mockk<NetworkResponse.ServerError<Unit, ApiError>> {
            every { code } returns 422
            every { this@mockk.error } returns error
            every { body } returns apiError
        }

        val result = networkResponse.toErr()

        assertEquals(422, result.error.httpErrorCode)
        assertEquals("400 BAD_REQUEST title 1", result.error.errorDetails)
    }

    @Test
    fun `WHEN server error with empty errors list THEN return repository error`() {
        val error = Throwable(
            message = "error message"
        )
        val apiError = ApiError(
            errors = listOf()
        )
        val networkResponse = mockk<NetworkResponse.ServerError<Unit, ApiError>> {
            every { code } returns 422
            every { this@mockk.error } returns error
            every { body } returns apiError
        }

        val result = networkResponse.toErr()

        assertEquals(422, result.error.httpErrorCode)
        assertEquals("error message", result.error.errorDetails)
    }

    @Test
    fun `WHEN server error with empty errors list and error THEN return repository error`() {
        val error = Throwable(
            message = "error message"
        )
        val apiError = ApiError(
            errors = listOf()
        )
        val networkResponse = mockk<NetworkResponse.ServerError<Unit, ApiError>> {
            every { code } returns 422
            every { this@mockk.error } returns error
            every { body } returns apiError
        }

        val result = networkResponse.toErr()

        assertEquals(422, result.error.httpErrorCode)
        assertEquals("error message", result.error.errorDetails)
    }

    @Test
    fun `WHEN server error with empty errors list and no error THEN return repository error`() {
        val apiError = ApiError(
            errors = listOf()
        )

        val networkResponse = mockk<NetworkResponse.ServerError<Unit, ApiError>> {
            every { code } returns 422
            every { body } returns apiError
            every { error } returns null
        }

        val result = networkResponse.toErr()

        assertEquals(422, result.error.httpErrorCode)
        assertEquals("Unknown error", result.error.errorDetails)
    }

    @Test
    fun `WHEN server error without body THEN return repository error`() {

        val networkResponse = mockk<NetworkResponse.ServerError<Unit, ApiError>> {
            every { code } returns 422
            every { body } returns null
        }

        val result = networkResponse.toErr()

        assertEquals(422, result.error.httpErrorCode)
        assertEquals("Unknown error", result.error.errorDetails)
    }

    @Test
    fun `WHEN throwable with code and message THEN return repository error with code and details`() {
        val error = Throwable(
            message = "error message"
        )

        val result = error.toNetworkError(
            code = 422
        )

        assertEquals(422, result.httpErrorCode)
        assertEquals("error message", result.errorDetails)
    }

    @Test
    fun `WHEN unknown error with code and message THEN returns repository error with code and details`() {
        val error = Throwable(
            message = "error message"
        )
        val networkResponse = mockk<NetworkResponse.UnknownError<Unit, ApiError>> {
            every { code } returns 422
            every { this@mockk.error } returns error
        }

        val result = networkResponse.toErr()

        assertEquals(422, result.error.httpErrorCode)
        assertEquals("error message", result.error.errorDetails)

    }

    @Test
    fun `WHEN network error THEN returns repository error with details`() {
        val error = Throwable(
            message = "error message"
        )
        val networkException = IOException(error)
        val networkResponse = mockk<NetworkResponse.NetworkError<Unit, ApiError>> {
            every { this@mockk.error } returns networkException
        }

        val result = networkResponse.toErr()

        assertEquals(null, result.error.httpErrorCode)
        assertEquals("java.lang.Throwable: error message", result.error.errorDetails)

    }
}
