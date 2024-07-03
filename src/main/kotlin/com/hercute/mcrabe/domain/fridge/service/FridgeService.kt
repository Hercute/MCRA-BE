package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest

interface FridgeService {

    fun createItemInFridge(memberId: Long, request: CreateFridgeRequest)

    fun updateItemOfFridge(memberId: Long, fridgeId: Long, request: UpdateFridgeRequest)

    fun deleteItemOfFridge(memberId: Long, fridgeId: Long)

    fun getItemOfFridge(memberId: Long, fridgeId: Long): FridgeResponse

    fun getItemListOfFridge(memberId: Long): List<FridgeResponse>
}