package com.hercute.mcrabe.domain.cart.service

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemListToSomething
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.cart.repository.CartRepository
import com.hercute.mcrabe.domain.categories.repository.CategoryRepository
import com.hercute.mcrabe.domain.fridge.model.Fridge
import com.hercute.mcrabe.domain.fridge.repository.FridgeRepository
import com.hercute.mcrabe.domain.members.repository.MemberRepository
import com.hercute.mcrabe.global.error.exception.InvalidCredentialException
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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
    override fun addItemInCart(memberId: Long, request: AddItemInCartRequest) {
        val member = memberRepository.findByIdOrNull(memberId)
            ?: throw ModelNotFoundException("member", memberId)
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

    override fun updateItemOfCart(memberId: Long, itemId: Long, request: UpdateItemInCartRequest) {
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw ModelNotFoundException("item", itemId)
        if (item.member.id != memberId) {
            throw InvalidCredentialException("유저정보가 일치하지 않습니다.")
        }
        item.category = category
        item.name = request.name
        item.memo = request.memo
    }

    override fun deleteItemOfCart(memberId: Long, request: ItemListToSomething) {
        val itemList = request.listOfItems.map {
            cartRepository.findByIdOrNull(it.id)
                ?: throw ModelNotFoundException("item", it.id)
        }
        itemList.map {
            cartRepository.delete(it)
        }
    }

    override fun getItemOfCart(memberId: Long, itemId: Long): ItemResponse {0
        val item = cartRepository.findByIdOrNull(itemId)
            ?: throw ModelNotFoundException("item", itemId)
        val category = categoryRepository.findByIdOrNull(item.category.id)
            ?: throw ModelNotFoundException("category", item.category.id)
        return ItemResponse.from(item,category)
    }

    override fun getItemList(memberId: Long, pageable: Pageable, purchasedDate: Timestamp?): Page<ItemResponse> {
        val itemList = cartRepository.findItemByPurchaseStatus(pageable, purchasedDate)
        return itemList.map {
            val category = categoryRepository.findByIdOrNull(it.category.id)
                ?: throw ModelNotFoundException("category", it.category.id)
            ItemResponse.from(it, category)
        }
    }

    override fun getCartRecords(memberId: Long): List<ItemResponse> {
        val cartRecord = cartRepository.findAllByMemberId(memberId)
            ?: throw ModelNotFoundException("item", memberId)
        return cartRecord.map {
            val category = categoryRepository.findByIdOrNull(it!!.category.id)
                ?: throw ModelNotFoundException("category", it.category.id)
            ItemResponse.from(it, category)
        }
    }

    override fun checkItemPurchaseStatus(request: ItemListToSomething) {
        //리스트를 찾은다음 구매여부를 true로 바꿈
        val itemToPurchase = request.listOfItems.map {
            cartRepository.findByIdOrNull(it.id)
                ?: throw ModelNotFoundException("item", it.id)
        }
        itemToPurchase.map {
            it.purchase = true
            cartRepository.save(it)
        }
    }

    override fun moveItemToFridge(memberId: Long, request: ItemListToSomething) {
        val itemToPurchase = request.listOfItems.map {
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
        //이후 삭제를 할지 말지는 고민을 조금 해봐야할듯
    }


}