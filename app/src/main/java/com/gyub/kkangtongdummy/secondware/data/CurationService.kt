package com.gyub.kkangtongdummy.secondware.data

import com.gyub.kkangtongdummy.secondware.network.ApiInfo
import retrofit2.http.GET

/**
 * 큐레이션 Service
 *
 * @author   Gyul
 * @created  2023/12/23
 */
interface CurationService {

    /**
     * 큐레이션 아이템 가져오기
     *
     * @return 큐레이션 아이템
     */
    @GET("${ApiInfo.VERSION}/curation/items")
    suspend fun getCurationItems(): CurationItemsResponse
}