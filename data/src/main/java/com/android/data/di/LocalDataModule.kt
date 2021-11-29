package com.android.data.di

import com.android.data.local.dao.UserDAO
import com.android.data.remote.UserAPIService
import com.android.data.repositories.dataSource.UserLocalDataSource
import com.android.data.repositories.dataSource.UserRemoteDataSource
import com.android.data.repositories.dataSourceImpl.UserLocalDataSourceImpl
import com.android.data.repositories.dataSourceImpl.UserRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideUserLocalDataSource(userDAO: UserDAO): UserLocalDataSource {
        return UserLocalDataSourceImpl(userDAO)
    }
}