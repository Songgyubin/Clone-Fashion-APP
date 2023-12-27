/*
 * Copyright ⓒ 2011 HelloMarket Inc. All Rights Reserved.
 */
package com.gyub.kkangtongdummy.secondwear.data

import com.gyub.kkangtongdummy.secondwear.domain.CurationItemsEntity
import com.gyub.kkangtongdummy.secondwear.domain.CurationRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 * 큐레이션 Repository 구현체
 *
 * @author   Gyul
 * @created  2023/12/23
 */
@Singleton
class CurationRepositoryImpl
@Inject
constructor(
    private val curationApiDataSource: CurationApiDataSource
) : CurationRepository {

    /**
     * 큐레이션 아이템 가져오기
     *
     * @return 큐레이션 아이템
     */
    override suspend fun getCurationItems(): CurationItemsEntity {
        return curationApiDataSource.getCurationItems().toEntity()
    }
}