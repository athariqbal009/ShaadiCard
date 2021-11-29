package com.android.shaadicard.di

import android.content.Context
import com.android.data.remote.UserAPIService
import com.android.shaadicard.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule() {

    @Singleton
    @Provides
    fun provideRetrofit(@ApplicationContext context: Context):Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(context.getString(R.string.BASE_URL))
            .build()
    }

    @Singleton
    @Provides
    fun provideLocationAPIService(retrofit: Retrofit):UserAPIService {
        return retrofit.create(UserAPIService::class.java)
    }
}