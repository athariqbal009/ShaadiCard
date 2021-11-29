package com.android.shaadicard.di

import android.content.Context
import com.android.shaadicard.adapter.UserAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideUserAdapter(@ApplicationContext context: Context):UserAdapter{
        return UserAdapter(context)
    }
}