package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class CartServiceImpl:CartService {
    override fun addItemInCart(memberId: Long, request: AddItemInCartRequest) {
        TODO("Not yet implemented")
    }

    override fun updateItemOfCart(memberId: Long, itemId: Long, request: UpdateItemInCartRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteItemOfCart(memberId: Long, itemId: Long) {
        TODO("Not yet implemented")
    }

    override fun getItemOfCart(memberId: Long, itemId: Long): ItemResponse {
        TODO("Not yet implemented")
    }

    override fun getItemList(memberId: Long, purchasedDate: Timestamp?): List<ItemResponse> {
        TODO("Not yet implemented")
    }

    override fun getCartRecords(memberId: Long): List<ItemResponse> {
        TODO("Not yet implemented")
    }

    override fun checkItemPurchaseStatus(memberId: Long, itemId: Long) {
        TODO("Not yet implemented")
    }

    override fun moveItemToFridge(memberId: Long) {
        TODO("Not yet implemented")
    }


}