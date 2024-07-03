package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import java.sql.Timestamp

interface CartService {

    fun addItemInCart(
        memberId: Long,
        request: AddItemInCartRequest
    )

    fun updateItemOfCart(
        memberId: Long,
        itemId: Long,
        request: UpdateItemInCartRequest
    )

    fun deleteItemOfCart(
        memberId: Long,
        itemId: Long,
    )

    fun getItemOfCart(
        memberId: Long,
        itemId: Long
    ): ItemResponse

    fun getItemList(
        memberId: Long,
        purchasedDate: Timestamp?
    ): List<ItemResponse>

    fun getCartRecords(
        memberId: Long
    ): List<ItemResponse>

    fun checkItemPurchaseStatus(
        memberId: Long,
        itemId: Long
    )

    fun moveItemToFridge(memberId: Long)
}