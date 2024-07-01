package com.hercute.mcrabe.domain.cart.dto

data class ItemResponse(
    val id: Long,
    val categoryId: Long,
    val memberId: Long,
    val name: String,
    val memo: String,
    val purchase: Boolean
)
