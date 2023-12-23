/*
 * Copyright ⓒ 2011 HelloMarket Inc. All Rights Reserved.
 */
package com.gyub.kkangtongdummy.secondware.domain

/**
 * 큐레이션 아이템 Entity
 *
 * @author   Gyul
 * @created  2023/12/23
 */
data class CurationItemsEntity(
    val items: List<ItemEntity>?
) {
    data class ItemEntity(
        val itemIdx: String?,
        val title: String?,
        val price: Int?
    )
}