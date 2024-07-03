package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemPurchaseOrMoveRequest
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.cart.repository.CartRepository
import com.hercute.mcrabe.domain.categories.repository.CategoryRepository
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class CartServiceImpl(
    private val cartRepository: CartRepository,
    private val categoryRepository: CategoryRepository
):CartService {
    override fun addItemInCart(request: AddItemInCartRequest) {
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        val item = Cart(
            name = request.name,
            memo = request.memo,
            category = category
            //카테고리 추가 필요
        )
        cartRepository.save(item)
    }

    override fun updateItemOfCart(itemId: Long, request: UpdateItemInCartRequest) {
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw Exception()
        item.category = category
        item.name = request.name
        item.memo = request.memo
    }

    override fun deleteItemOfCart(itemId: Long) {
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw ModelNotFoundException("item", itemId)
        cartRepository.delete(item)
    }

    override fun getItemOfCart(itemId: Long): ItemResponse {
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw ModelNotFoundException("item", itemId)
        return ItemResponse.from(item)
    }

    override fun getItemList(purchasedDate: Timestamp?): List<ItemResponse> {
        TODO("Not yet implemented")
    }

    override fun getCartRecords(): List<ItemResponse> {
        TODO("Not yet implemented")
    }

    override fun checkItemPurchaseStatus(itemList: ItemPurchaseOrMoveRequest) {
        TODO()
        //리스트를 찾은다음 구매여부를 true로 바꿈
    }

    override fun moveItemToFridge(itemList: ItemPurchaseOrMoveRequest) {
        TODO("Not yet implemented")
        //리스트를 찾은다음 냉장고에 저장 및 기존 아이템들은 삭제처리..?
    }


}