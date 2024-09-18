package com.example.featherlyspy.di.network

import android.content.Context
import com.example.featherlyspy.di.annotations.ApiEBirdEndpoint
import com.example.featherlyspy.di.annotations.ApiNuthatchEndpoint
import com.example.featherlyspy.network.endpoint.ApiEndpointProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApiEndpointModule {

    @Provides
    fun getApiEndpointProvider(
        @ApplicationContext context: Context
    ): ApiEndpointProvider =
        ApiEndpointProvider(
            context = context
        )

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
