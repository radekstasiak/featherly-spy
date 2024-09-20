package com.example.featherlyspy.di.network

import com.example.featherlyspy.config.AppHeaderProvider
import com.example.featherlyspy.config.HeaderProvider
import com.example.featherlyspy.di.annotations.EBirdOkHttpClient
import com.example.featherlyspy.network.okhttp.OkHttpClientFactory
import com.example.featherlyspy.network.okhttp.interceptor.EBirdHttpClientInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

interface OkHttpModule {

    @Module
    @InstallIn(SingletonComponent::class)
    interface Config {
        @Binds
        fun bindHeaderProvider(
            appHeaderProvider: AppHeaderProvider
        ): HeaderProvider
    }

    @Module
    @InstallIn(SingletonComponent::class)
    class Client {

        @Provides
        fun getEBirdOkHttpClientInterceptor(
            headerProvider: HeaderProvider
        ): EBirdHttpClientInterceptor =
            EBirdHttpClientInterceptor(
                headerProvider = headerProvider
            )

        @Provides
        fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return httpLoggingInterceptor
        }

        @Provides
        fun getOkHttpClientFactory(
            eBirdHttpClientInterceptor: EBirdHttpClientInterceptor,
            httpLoggingInterceptor:HttpLoggingInterceptor
        ): OkHttpClientFactory = OkHttpClientFactory(
            eBirdHttpClientInterceptor = eBirdHttpClientInterceptor,
            httpLoggingInterceptor=httpLoggingInterceptor
        )

        @Provides
        @EBirdOkHttpClient
        fun getEBirdOkHttpClient(
            okHttpClientFactory: OkHttpClientFactory
        ): OkHttpClient = okHttpClientFactory.eBirdOkHttpClient

    }
}
