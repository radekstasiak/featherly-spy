package com.example.featherlyspy.di.network

import com.example.featherlyspy.di.annotations.ApiEBirdEndpoint
import com.example.featherlyspy.di.annotations.ApiNuthatchEndpoint
import com.example.featherlyspy.network.endpoint.ApiEndpointProvider
import com.example.featherlyspy.network.endpoint.ApiEndpointProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


interface ApiEndpointModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface Provider {
        @Binds
        fun getApiEndpointProvider(
            apiEndpointProvider: ApiEndpointProviderImpl
        ): ApiEndpointProvider
    }

    @Module
    @InstallIn(SingletonComponent::class)
    class Endpoint {
        @Provides
        @ApiEBirdEndpoint
        fun getEBirdApiEndpoint(
            apiEndpointProvider: ApiEndpointProvider
        ): String =
            apiEndpointProvider.eBirdApiEndpoint

        @Provides
        @ApiNuthatchEndpoint
        fun getNuthatchEndpoint(
            apiEndpointProvider: ApiEndpointProvider
        ): String =
            apiEndpointProvider.nuthatchEndpoint
    }
}
