package com.example.featherlyspy.domain.base

import com.example.featherlyspy.network.model.NetworkError
import javax.inject.Inject

class DomainErrorMapper @Inject constructor() : DomainMapper<NetworkError?, DomainError> {

    override fun toDomain(input: NetworkError?): DomainError =
        if (input != null && input.errors.isNotEmpty()) {
            DomainError.GenericError(
                details = input.errors[0].title
            )
        } else {
            DomainError.UnknownError
        }
}
