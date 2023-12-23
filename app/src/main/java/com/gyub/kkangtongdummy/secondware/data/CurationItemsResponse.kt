package com.gyub.kkangtongdummy.secondware.data

import com.gyub.kkangtongdummy.secondware.domain.CurationItemsEntity

/**
 * 큐레이션 아이템 Response
 *
 * @author   Gyul
 * @created  2023/12/23
 */
data class CurationItemsResponse(
    val items: List<ItemResponse>
) {
    data class ItemResponse(
        val itemIdx: String?,
        val title: String?,
        val price: Int?,
    )
}

/**
 * Mapper
 * [CurationItemsResponse] to [CurationItemsEntity]
 *
 * @return [CurationItemsEntity]
 */
fun CurationItemsResponse.toEntity(): CurationItemsEntity {
    return CurationItemsEntity(
        this.items.map {
            CurationItemsEntity.ItemEntity(
                itemIdx = it.itemIdx,
                title = it.title,
                price = it.price
            )
        }
    )
}