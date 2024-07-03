package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.categories.repository.CategoryRepository
import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest
import com.hercute.mcrabe.domain.fridge.model.Fridge
import com.hercute.mcrabe.domain.fridge.repository.FridgeRepository
import com.hercute.mcrabe.domain.members.repository.MemberRepository
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@Service
class FridgeServiceImpl(
    private val fridgeRepository: FridgeRepository,
    private val categoryRepository: CategoryRepository,
    private val memberRepository: MemberRepository
): FridgeService {
    override fun createItemInFridge(request: CreateFridgeRequest) {
        val member = memberRepository.findByIdOrNull(0)
            ?: throw ModelNotFoundException("member", 0)
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        val item = Fridge(
            name = request.name,
            expirationDate = request.expirationDate,
            memo = request.memo,
            storage = request.storage,
            category = category,
            member = member
        )
        fridgeRepository.save(item)
    }

    override fun updateItemOfFridge(fridgeId: Long, request: UpdateFridgeRequest) {
        //자기 냉장고속 아이템인지 확인하는 절차 필요할지도?
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw ModelNotFoundException("Item", fridgeId)
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        item.category = category
        item.name = request.name
        item.expirationDate = request.expirationDate
        item.memo = request.memo
        item.storage = request.storage
        fridgeRepository.save(item)
    }

    override fun deleteItemOfFridge(fridgeId: Long) {
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw ModelNotFoundException("Item", fridgeId)
        fridgeRepository.delete(item)
    }

    override fun getItemOfFridge(fridgeId: Long): FridgeResponse {
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw ModelNotFoundException("Item", fridgeId)
        return FridgeResponse.from(item)
    }

    override fun getItemListOfFridge(): List<FridgeResponse> {
        val itemList = fridgeRepository.findByMemberId(0) //유저프린시펄 추가후 수정필요
        return itemList.map { FridgeResponse.from(it) }
    }
}