package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemPurchaseOrMoveRequest
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.cart.repository.CartRepository
import com.hercute.mcrabe.domain.categories.repository.CategoryRepository
import com.hercute.mcrabe.domain.fridge.model.Fridge
import com.hercute.mcrabe.domain.fridge.repository.FridgeRepository
import com.hercute.mcrabe.domain.members.repository.MemberRepository
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.sql.Timestamp

@Service
class CartServiceImpl(
    private val cartRepository: CartRepository,
    private val fridgeRepository: FridgeRepository,
    private val categoryRepository: CategoryRepository,
    private val memberRepository: MemberRepository
):CartService {
    override fun addItemInCart(request: AddItemInCartRequest) {
        val member = memberRepository.findByIdOrNull(0) //유저프린시펄 추가후 수정필요
            ?: throw ModelNotFoundException("member", 0)
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        val item = Cart(
            name = request.name,
            memo = request.memo,
            category = category,
            member = member
        )
        cartRepository.save(item)
    }

    override fun updateItemOfCart(itemId: Long, request: UpdateItemInCartRequest) {
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw ModelNotFoundException("item", itemId)
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
        if (purchasedDate != null) {

        } else {
//            cartRepository.findByIdOrNull()
        }
        TODO()
    }

    override fun getCartRecords(): List<ItemResponse> {
        TODO("Not yet implemented")
    }

    override fun checkItemPurchaseStatus(request: ItemPurchaseOrMoveRequest) {
        //리스트를 찾은다음 구매여부를 true로 바꿈
        val itemToPurchase = request.listOfItemsToPurchase.map {
            cartRepository.findByIdOrNull(it.id)
                ?: throw ModelNotFoundException("item", it.id)
        }
        itemToPurchase.map {
            it.purchase = true
            cartRepository.save(it)
        }
    }

    override fun moveItemToFridge(request: ItemPurchaseOrMoveRequest) {
        val itemToPurchase = request.listOfItemsToPurchase.map {
            cartRepository.findByIdOrNull(it.id)
                ?: throw ModelNotFoundException("item", it.id)
        }
        itemToPurchase.map {
            val fridge = Fridge (
                name = it.name,
                memo = it.memo,
                category = it.category,
                member = it.member
            )
            fridgeRepository.save(fridge)
        }
    }


}