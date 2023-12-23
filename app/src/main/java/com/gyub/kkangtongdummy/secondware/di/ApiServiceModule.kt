package com.gyub.kkangtongdummy.secondware.di

import com.gyub.kkangtongdummy.secondware.data.CurationService
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