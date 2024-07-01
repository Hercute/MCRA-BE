package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest
import org.springframework.stereotype.Service

@Service
class FridgeServiceImpl: FridgeService {
    override fun createFridge(memberId: String, request: CreateFridgeRequest) {
        TODO("Not yet implemented")
    }

    override fun updateFridge(memberId: String, fridgeId: Long, request: UpdateFridgeRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteFridge(memberId: String, fridgeId: Long) {
        TODO("Not yet implemented")
    }

    override fun getFridge(memberId: Long, fridgeId: Long): FridgeResponse {
        TODO("Not yet implemented")
    }

    override fun getFridgeList(memberId: Long): List<FridgeResponse> {
        TODO("Not yet implemented")
    }
}