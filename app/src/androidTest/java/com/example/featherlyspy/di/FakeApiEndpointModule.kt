package com.example.featherlyspy.di

import com.example.featherlyspy.di.network.ApiEndpointModule
import com.example.featherlyspy.network.endpoint.ApiEndpointProvider
import com.example.featherlyspy.utils.FakeApiEndpointProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn

@Module
@TestInstallIn(
    replaces = [ApiEndpointModule.Provider::class],
    components = [SingletonComponent::class]
)
interface FakeApiEndpointModule {

    @Binds
    fun getApiEndpointProvider(
        apiEndpointProvider: FakeApiEndpointProvider
    ): ApiEndpointProvider
}
