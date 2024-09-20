package com.example.featherlyspy.domain.base

sealed class DomainError(val message: String = "") {

    data class GenericError(val details: String) : DomainError(details)
    data object UnknownError : DomainError()
}
