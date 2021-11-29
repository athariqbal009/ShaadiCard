package com.android.shaadicard.di

import com.android.domain.repositories.UserRepository
import com.android.domain.usecases.GetSavedUserUseCase
import com.android.domain.usecases.GetUserUseCase
import com.android.domain.usecases.SaveUserUseCase
import com.android.domain.usecases.UpdateSavedUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetUserUseCase(userRepository: UserRepository): GetUserUseCase {
        return GetUserUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideSaveUserUseCase(userRepository: UserRepository): SaveUserUseCase {
        return SaveUserUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedUserUseCase(userRepository: UserRepository): GetSavedUserUseCase {
        return GetSavedUserUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideUpdateSavedUserUseCase(userRepository: UserRepository): UpdateSavedUserUseCase {
        return UpdateSavedUserUseCase(userRepository)
    }
}