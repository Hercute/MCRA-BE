package com.hercute.mcrabe.domain.cart.dto

data class UpdateItemInCartRequest (
    val id: Long,
    val categoryId: Long,
    val name: String,
    val memo: String,
)