package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest

interface FridgeService {

    fun createFridge(memberId: String, request: CreateFridgeRequest)

    fun updateFridge(memberId: String, fridgeId: Long, request: UpdateFridgeRequest)

    fun deleteFridge(memberId: String, fridgeId: Long)

    fun getFridge(memberId: Long, fridgeId: Long): FridgeResponse

    fun getFridgeList(memberId: Long): List<FridgeResponse>
}