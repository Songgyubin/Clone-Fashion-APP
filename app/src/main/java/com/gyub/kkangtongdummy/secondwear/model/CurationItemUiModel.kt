package com.gyub.kkangtongdummy.secondwear.model

import com.gyub.kkangtongdummy.secondwear.domain.CurationItemEntity
import com.gyub.kkangtongdummy.util.extension.orDefault

/**
 * 큐레이션 UI Model
 *
 * @author   Gyul
 * @created  2023/12/27
 */
data class CurationItemUiModel(
    val itemIdx: String = "",
    val title: String = "",
    val price: Int
)

/**
 * Mapper
 * List[CurationItemEntity] to List[CurationItemUiModel]
 *
 * @return List[CurationItemUiModel]
 */
fun List<CurationItemEntity>.toUiModel(): List<CurationItemUiModel> {
    return this.map {
        CurationItemUiModel(
            itemIdx = it.itemIdx.orEmpty(),
            title = it.title.orEmpty(),
            price = it.price.orDefault()
        )
    }
}