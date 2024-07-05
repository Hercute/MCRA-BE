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
        request: ItemListToSomething,
    )

    fun getItemOfCart(
//        userPrincipal: UserPrincipal,
        itemId: Long
    ): ItemResponse

    fun getItemList(
        pageable: Pageable,
//        userPrincipal: UserPrincipal,
        purchasedDate: Timestamp?
    ): Page<ItemResponse>

    fun getCartRecords(
//        userPrincipal: UserPrincipal,
    ): List<ItemResponse>

    fun checkItemPurchaseStatus(
        request: ItemListToSomething
    )

    fun moveItemToFridge(
//        userPrincipal: UserPrincipal,
        request: ItemListToSomething
    )
}