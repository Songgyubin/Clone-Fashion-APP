package com.gyub.kkangtongdummy.secondwear.di

import com.gyub.kkangtongdummy.secondwear.data.CurationService
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

object ApiServiceModule {
    @Singleton
    @Provides
    fun provideCurationService(retrofit: Retrofit.Builder): CurationService {
        return retrofit
            .build()
            .create(CurationService::class.java)
    }
}