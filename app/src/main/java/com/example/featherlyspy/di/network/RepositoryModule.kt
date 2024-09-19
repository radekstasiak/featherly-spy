package com.example.featherlyspy.di.network

import com.example.featherlyspy.data.repository.EBirdRepository
import com.example.featherlyspy.data.repository.EBirdRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindEBirdRepository(
        eBirdRepositoryImpl: EBirdRepositoryImpl
    ): EBirdRepository
}
