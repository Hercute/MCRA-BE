package com.hercute.mcrabe.domain.cart.dto

data class ItemPurchaseOrMoveRequest (
    val listOfItemsToPurchase: MutableList<ItemId> = mutableListOf()
)