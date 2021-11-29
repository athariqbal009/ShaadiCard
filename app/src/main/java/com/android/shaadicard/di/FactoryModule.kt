package com.android.shaadicard.di

import android.app.Application
import com.android.domain.usecases.GetSavedUserUseCase
import com.android.domain.usecases.GetUserUseCase
import com.android.domain.usecases.SaveUserUseCase
import com.android.domain.usecases.UpdateSavedUserUseCase
import com.android.shaadicard.vm.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Singleton
    @Provides
    fun provideViewModelFactory(
        application: Application,
        getUserUseCase: GetUserUseCase,
        saveUserUseCase: SaveUserUseCase,
        getSavedUserUseCase: GetSavedUserUseCase,
        updateSavedUserUseCase: UpdateSavedUserUseCase
    ): ViewModelFactory {
        return ViewModelFactory(
            application,
            getUserUseCase,
            saveUserUseCase,
            getSavedUserUseCase,
            updateSavedUserUseCase
        )
    }

}