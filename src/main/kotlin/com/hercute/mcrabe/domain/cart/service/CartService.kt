package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemPurchaseOrMoveRequest
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import java.sql.Timestamp

interface CartService {

    fun addItemInCart(
//        userPrincipal: UserPrincipal,
        request: AddItemInCartRequest
    )

    fun updateItemOfCart(
//        userPrincipal: UserPrincipal,
        itemId: Long,
        request: UpdateItemInCartRequest
    )

    fun deleteItemOfCart(
//        userPrincipal: UserPrincipal,
        itemId: Long,
    )

    fun getItemOfCart(
//        userPrincipal: UserPrincipal,
        itemId: Long
    ): ItemResponse

    fun getItemList(
//        userPrincipal: UserPrincipal,
        purchasedDate: Timestamp?
    ): List<ItemResponse>

    fun getCartRecords(
//        userPrincipal: UserPrincipal,
    ): List<ItemResponse>

    fun checkItemPurchaseStatus(
        itemList: ItemPurchaseOrMoveRequest
    )

    fun moveItemToFridge(
//        userPrincipal: UserPrincipal,
        itemList: ItemPurchaseOrMoveRequest
    )
}