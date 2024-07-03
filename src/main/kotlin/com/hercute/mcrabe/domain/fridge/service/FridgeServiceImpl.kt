package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.categories.repository.CategoryRepository
import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest
import com.hercute.mcrabe.domain.fridge.model.Fridge
import com.hercute.mcrabe.domain.fridge.repository.FridgeRepository
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Private

@Service
class FridgeServiceImpl(
    private val fridgeRepository: FridgeRepository,
    private val categoryRepository: CategoryRepository
): FridgeService {
    override fun createItemInFridge(memberId: Long, request: CreateFridgeRequest) {
//        val member = Member (
//
//        ) //멤버 엔티티 추가후 수정필요, 카테고리도 추가 필요
        val category = categoryRepository.findByIdOrNull(request.categoryId)
            ?: throw ModelNotFoundException("category", request.categoryId)
        val item = Fridge(
            name = request.name,
            expirationDate = request.expirationDate,
            memo = request.memo,
            storage = request.storage,
            category = category
        )
        fridgeRepository.save(item)
    }

    override fun updateItemOfFridge(memberId: Long, fridgeId: Long, request: UpdateFridgeRequest) {
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

    override fun deleteItemOfFridge(memberId: Long, fridgeId: Long) {
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw ModelNotFoundException("Item", fridgeId)
        fridgeRepository.delete(item)
    }

    override fun getItemOfFridge(memberId: Long, fridgeId: Long): FridgeResponse {
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw ModelNotFoundException("Item", fridgeId)
        return FridgeResponse.from(item)
    }

    override fun getItemListOfFridge(memberId: Long): List<FridgeResponse> {
//        val itemList = fridgeRepository.findByMemberId(memberId)
        TODO()
    }
}