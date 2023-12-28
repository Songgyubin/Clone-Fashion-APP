package com.gyub.kkangtongdummy.secondwear.di

import com.gyub.kkangtongdummy.secondwear.data.CurationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    @Singleton
    @Provides
    fun provideCurationService(retrofit: Retrofit.Builder): CurationService {
        return retrofit
            .build()
            .create(CurationService::class.java)
    }
}