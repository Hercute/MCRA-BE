package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest
import com.hercute.mcrabe.domain.fridge.model.Fridge
import com.hercute.mcrabe.domain.fridge.repository.FridgeRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class FridgeServiceImpl(
    private val fridgeRepository: FridgeRepository
): FridgeService {
    override fun createItemInFridge(memberId: Long, request: CreateFridgeRequest) {
//        val member = Member (
//
//        ) //멤버 엔티티 추가후 수정필요, 카테고리도 추가 필요
        val item = Fridge(
            name = request.name,
            expirationDate = request.expirationDate,
            memo = request.memo,
            storage = request.storage
        )
        fridgeRepository.save(item)
    }

    override fun updateItemOfFridge(memberId: Long, fridgeId: Long, request: UpdateFridgeRequest) {
        //자기 냉장고속 아이템인지 확인하는 절차 필요할지도?
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw Exception() //예외처리폴더 추가후 수정 필요
        item.name = request.name
        item.expirationDate = request.expirationDate
        item.memo = request.memo
        item.storage = request.storage
        fridgeRepository.save(item)
    }

    override fun deleteItemOfFridge(memberId: Long, fridgeId: Long) {
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw Exception() //예외처리폴더 추가후 수정 필요
        fridgeRepository.delete(item)
    }

    override fun getItemOfFridge(memberId: Long, fridgeId: Long): FridgeResponse {
        val item = fridgeRepository.findByIdOrNull(fridgeId)
            ?: throw Exception() //예외처리폴더 추가후 수정 필요
        return FridgeResponse.from(item)
    }

    override fun getItemListOfFridge(memberId: Long): List<FridgeResponse> {
//        val itemList = fridgeRepository.findByMemberId(memberId)
        TODO()
    }
}