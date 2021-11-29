package com.android.data.di

import com.android.data.remote.UserAPIService
import com.android.data.repositories.dataSource.UserRemoteDataSource
import com.android.data.repositories.dataSourceImpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(
        userAPIService: UserAPIService
    ):UserRemoteDataSource{
        return UserRemoteDataSourceImpl(userAPIService)
    }

}