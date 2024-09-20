package com.example.featherlyspy.domain.base

interface DomainMapper<in I, out O> {

    fun toDomain(input: I): O
}
