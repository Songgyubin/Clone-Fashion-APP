/*
 * Copyright ⓒ 2011 HelloMarket Inc. All Rights Reserved.
 */
package com.gyub.kkangtongdummy.secondware.di

import com.gyub.kkangtongdummy.secondware.data.CurationRepositoryImpl
import com.gyub.kkangtongdummy.secondware.domain.CurationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Repository Module (interface + @binds)
 *
 * @author   Gyul
 * @created  2023/12/23
 */
@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindCurationRepository(curationRepositoryImpl: CurationRepositoryImpl): CurationRepository
}