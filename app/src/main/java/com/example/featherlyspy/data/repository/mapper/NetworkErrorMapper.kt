package com.example.featherlyspy.data.repository.mapper

import com.example.featherlyspy.data.repository.model.RepositoryError
import com.example.featherlyspy.network.model.ApiError
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Result
import com.haroldadmin.cnradapter.NetworkResponse

private const val GENERIC_ERROR_MESSAGE = "Unknown error"

fun <S> NetworkResponse.Error<S, ApiError>.toNetworkError(): RepositoryError =
    when (this) {
        is NetworkResponse.ServerError ->
            this.body?.let {
                if (it.errors.isNotEmpty()) {
                    RepositoryError(
                        httpErrorCode = code,
                        errorDetails = "${it.errors[0].status} + ${it.errors[0].title}"
                    )
                } else {
                    error?.toNetworkError()
                } ?: error?.toNetworkError() ?: RepositoryError(
                    errorDetails = GENERIC_ERROR_MESSAGE,
                    httpErrorCode = code
                )
            } ?: RepositoryError(
                errorDetails = GENERIC_ERROR_MESSAGE,
                httpErrorCode = code
            )

        is NetworkResponse.NetworkError -> error.toNetworkError()

        is NetworkResponse.UnknownError -> error.toNetworkError(
            code = code
        )
    }


fun <S> NetworkResponse.Error<S, ApiError>.toErr(): Result<S, RepositoryError> =
    Err(this.toNetworkError())


fun Throwable.toNetworkError(code: Int? = null): RepositoryError =
    RepositoryError(
        httpErrorCode = code,
        errorDetails = this.localizedMessage ?: this.message.orEmpty()
    )

