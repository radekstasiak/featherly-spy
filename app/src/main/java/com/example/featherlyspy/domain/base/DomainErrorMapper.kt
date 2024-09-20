package com.example.featherlyspy.domain.base

import com.example.featherlyspy.network.model.RestError
import javax.inject.Inject

class DomainErrorMapper @Inject constructor() : DomainMapper<RestError?, DomainError> {

    override fun toDomain(input: RestError?): DomainError =
        if (input != null && input.errors.isNotEmpty()) {
            DomainError.GenericError(
                details = input.errors[0].title
            )
        } else {
            DomainError.UnknownError
        }
}
