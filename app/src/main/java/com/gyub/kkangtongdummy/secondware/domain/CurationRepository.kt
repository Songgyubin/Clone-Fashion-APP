package com.gyub.kkangtongdummy.secondware.domain

/**
 * 큐레이션 Repository
 *
 * @author   Gyul
 * @created  2023/12/23
 */
interface CurationRepository {

    /**
     * 큐레이션 아이템 가져오기
     *
     * @return 큐레이션 아이템
     */
    suspend fun getCurationItems(): CurationItemsEntity
}