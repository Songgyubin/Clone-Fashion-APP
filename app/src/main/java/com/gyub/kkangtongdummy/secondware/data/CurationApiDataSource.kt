package com.gyub.kkangtongdummy.secondware.data

import javax.inject.Inject

/**
 * 큐레이션 Data Source
 *
 * @author   Gyul
 * @created  2023/12/23
 */
class CurationApiDataSource
@Inject
constructor(
    private val curationService: CurationService
) {

    /**
     * 큐레이션 아이템 가져오기
     *
     * @return 큐레이션 아이템
     */
    suspend fun getCurationItems(): CurationItemsResponse {
        return curationService.getCurationItems()
    }
}