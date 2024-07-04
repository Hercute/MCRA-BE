package com.hercute.mcrabe.domain.cart.dto

import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.categories.model.Categories
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.model.Fridge

data class ItemResponse(
    val id: Long,
    val mainCategory: String,
    val subCategory: String,
    val memberId: Long,
    val name: String,
    val memo: String,
    val purchase: Boolean
) {
    companion object {
        fun from(cart: Cart, category: Categories): ItemResponse {
            return ItemResponse (
                id = cart.id!!,
                mainCategory = category.main,
                subCategory = category.sub,
                memberId = cart.member.id!!,
                name = cart.name,
                memo = cart.memo,
                purchase = cart.purchase
            )
        }
    }
}
