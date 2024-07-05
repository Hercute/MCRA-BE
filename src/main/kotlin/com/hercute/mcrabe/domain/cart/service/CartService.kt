package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemListToSomething
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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
        request: ItemListToSomething,
    )

    fun getItemOfCart(
        memberId: Long,
        itemId: Long
    ): ItemResponse

    fun getItemList(
        memberId: Long,
        pageable: Pageable,
        purchasedDate: Timestamp?
    ): Page<ItemResponse>

    fun getCartRecords(
        memberId: Long,
    ): List<ItemResponse>

    fun checkItemPurchaseStatus(
        request: ItemListToSomething
    )

    fun moveItemToFridge(
        memberId: Long,
        request: ItemListToSomething
    )
}