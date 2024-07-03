package com.hercute.mcrabe.domain.fridge.service

import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest

interface FridgeService {

    fun createItemInFridge(request: CreateFridgeRequest)

    fun updateItemOfFridge(fridgeId: Long, request: UpdateFridgeRequest)

    fun deleteItemOfFridge( fridgeId: Long)

    fun getItemOfFridge(fridgeId: Long): FridgeResponse

    fun getItemListOfFridge(): List<FridgeResponse>
}