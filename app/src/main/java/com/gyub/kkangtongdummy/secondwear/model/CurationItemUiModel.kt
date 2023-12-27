package com.gyub.kkangtongdummy.secondwear.model

import com.gyub.kkangtongdummy.secondwear.domain.CurationItemsEntity
import com.gyub.kkangtongdummy.util.extension.orDefault

/**
 * 큐레이션 UI Model
 *
 * @author   Gyul
 * @created  2023/12/27
 */
data class CurationItemUiModel(
    val items: List<ItemUiModel> = listOf()
) {
    data class ItemUiModel(
        val itemIdx: String = "",
        val title: String = "",
        val price: Int
    )
}

/**
 * Mapper
 * [CurationItemsEntity] to [CurationItemUiModel]
 *
 * @return [CurationItemUiModel]
 */
fun CurationItemsEntity.toUiModel(): CurationItemUiModel {
    return CurationItemUiModel(
        this.items?.map {
            CurationItemUiModel.ItemUiModel(
                itemIdx = it.itemIdx.orEmpty(),
                title = it.title.orEmpty(),
                price = it.price.orDefault()
            )
        }.orEmpty()
    )
}