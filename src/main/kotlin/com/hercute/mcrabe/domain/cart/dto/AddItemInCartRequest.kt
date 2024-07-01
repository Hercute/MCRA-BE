package com.hercute.mcrabe.domain.cart.dto

data class AddItemInCartRequest(
    val categoryId: Long,
    val name: String,
    val memo: String,
)
