package com.hercute.mcrabe.domain.cart.dto

import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.model.Fridge

data class ItemResponse(
    val id: Long,
//    val categoryId: Long,
//    val memberId: Long,
    val name: String,
    val memo: String,
    val purchase: Boolean
) {
    companion object {
        fun from(cart: Cart): ItemResponse {
            return ItemResponse (
                id = cart.id!!,
//                categoryId = fridge.category.id,
//                memberId = fridge.member.id,
                name = cart.name,
                memo = cart.memo,
                purchase = cart.purchase
            )
        }
    }
}
