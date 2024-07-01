package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest

interface FridgeService {

    fun createFridge(memberId: Long, request: CreateFridgeRequest)

    fun updateFridge(memberId: Long, fridgeId: Long, request: UpdateFridgeRequest)

    fun deleteFridge(memberId: Long, fridgeId: Long)

    fun getFridge(memberId: Long, fridgeId: Long): FridgeResponse

    fun getFridgeList(memberId: Long): List<FridgeResponse>
}