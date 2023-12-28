/*
 * Copyright ⓒ 2011 HelloMarket Inc. All Rights Reserved.
 */
package com.gyub.kkangtongdummy.secondwear.domain

import com.gyub.kkangtongdummy.secondwear.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * 큐레이션 아이템 가져오기 Use Case
 *
 * @author   Gyul
 * @created  2023/12/23
 */
class GetCurationItemsUseCase
@Inject
constructor(
    private val curationRepository: CurationRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<List<CurationItemEntity>> = flow {
        val item = curationRepository.getCurationItems()
        emit(item)
    }.flowOn(ioDispatcher)
}