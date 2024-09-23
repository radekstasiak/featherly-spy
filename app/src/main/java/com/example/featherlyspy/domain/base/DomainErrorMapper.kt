package com.example.featherlyspy.domain.base

import com.example.featherlyspy.data.repository.model.RepositoryError
import com.example.featherlyspy.network.model.ApiError
import javax.inject.Inject

class DomainErrorMapper @Inject constructor() : DomainMapper<RepositoryError, DomainError> {

    override fun toDomain(input: RepositoryError): DomainError =
        DomainError.GenericError(
            details = input.errorDetails
        )

}
