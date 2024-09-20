package com.example.featherlyspy.di.network

import com.example.featherlyspy.di.annotations.ApiEBirdEndpoint
import com.example.featherlyspy.di.annotations.EBirdOkHttpClient
import com.example.featherlyspy.network.api.EBirdApiService
import com.example.featherlyspy.network.retrofit.EBirdRetrofitFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideEBirdRetrofitFactory(
        @ApiEBirdEndpoint apiEndpoint: String,
        @EBirdOkHttpClient okHttpClient: OkHttpClient
    ): EBirdRetrofitFactory = EBirdRetrofitFactory(
        apiEndpoint = apiEndpoint,
        okHttpClient = okHttpClient
    )

    @Provides
    fun provideEBirdApiService(
        retrofitFactory: EBirdRetrofitFactory
    ): EBirdApiService =
        retrofitFactory.service
}
