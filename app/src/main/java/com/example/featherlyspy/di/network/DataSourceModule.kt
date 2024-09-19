package com.example.featherlyspy.di.network

import com.example.featherlyspy.data.datasource.EBirdDataSource
import com.example.featherlyspy.data.datasource.EBirdRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindEBirdDataSource(
        eBirdRemoteDataSource: EBirdRemoteDataSource
    ): EBirdDataSource
}
