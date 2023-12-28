package com.gyub.kkangtongdummy.secondwear.data

import com.gyub.kkangtongdummy.secondwear.domain.CurationItemEntity

/**
 * 큐레이션 아이템 Response
 *
 * @author   Gyul
 * @created  2023/12/23
 */
data class CurationItemResponse(
    val itemIdx: String?,
    val title: String?,
    val price: Int?,
)

/**
 * Mapper
 * List[CurationItemResponse] to List[CurationItemEntity]
 *
 * @return List[CurationItemEntity]
 */
fun List<CurationItemResponse>.toEntity(): List<CurationItemEntity> {
    return this.map {
        CurationItemEntity(
            itemIdx = it.itemIdx,
            title = it.title,
            price = it.price
        )
    }
}