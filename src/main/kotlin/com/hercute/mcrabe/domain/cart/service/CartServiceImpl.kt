package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.cart.repository.CartRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class CartServiceImpl(
    private val cartRepository: CartRepository
):CartService {
    override fun addItemInCart(memberId: Long, request: AddItemInCartRequest) {
        val item = Cart(
            name = request.name,
            memo = request.memo
            //카테고리 추가 필요
        )
        cartRepository.save(item)
    }

    override fun updateItemOfCart(memberId: Long, itemId: Long, request: UpdateItemInCartRequest) {
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw Exception()
        item.name = request.name
        item.memo = request.memo
    }

    override fun deleteItemOfCart(memberId: Long, itemId: Long) {
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw Exception()
        cartRepository.delete(item)
    }

    override fun getItemOfCart(memberId: Long, itemId: Long): ItemResponse {
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw Exception()
        return ItemResponse.from(item)
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