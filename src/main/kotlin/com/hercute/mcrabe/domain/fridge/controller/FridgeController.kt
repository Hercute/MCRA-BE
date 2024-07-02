package com.hercute.mcrabe.domain.fridge.controller

import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest
import com.hercute.mcrabe.domain.fridge.service.FridgeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/{memberId}/fridges")
class FridgeController(
    private val fridgeService: FridgeService
) {

    @PostMapping
    fun createItemInFridge(
        @PathVariable memberId: Long,
        @RequestBody request: CreateFridgeRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(fridgeService.createItemInFridge(memberId, request))
    }

    @PutMapping("/{fridgeId}")
    fun updateItemOfFridge(
        @PathVariable memberId: Long,
        @PathVariable fridgeId: Long,
        @RequestBody request: UpdateFridgeRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(fridgeService.updateItemOfFridge(memberId, fridgeId, request))
    }

    @DeleteMapping("/{fridgeId}")
    fun deleteItemOfFridge(
        @PathVariable memberId: Long,
        @PathVariable fridgeId: Long
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(fridgeService.deleteItemOfFridge(memberId, fridgeId))
    }

    @GetMapping("/{fridgeId}")
    fun getItemOfFridge(
        @PathVariable memberId: Long,
        @PathVariable fridgeId: Long
    ): ResponseEntity<FridgeResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(fridgeService.getItemOfFridge(memberId, fridgeId))
    }

    @GetMapping()
    fun getItemListOfFridge(
        @PathVariable memberId: Long,
    ): ResponseEntity<List<FridgeResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(fridgeService.getItemListOfFridge(memberId))
    }



}