package com.android.shaadicard.di

import com.android.data.repositories.UserRepositoryImpl
import com.android.data.repositories.dataSource.UserLocalDataSource
import com.android.data.repositories.dataSource.UserRemoteDataSource
import com.android.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        userRemoteDataSource: UserRemoteDataSource,
        userLocalDataSource: UserLocalDataSource
    ): UserRepository {
        return UserRepositoryImpl(
            userRemoteDataSource,
            userLocalDataSource
        )
    }
}