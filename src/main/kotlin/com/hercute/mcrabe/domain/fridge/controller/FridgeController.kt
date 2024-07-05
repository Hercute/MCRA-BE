package com.hercute.mcrabe.domain.fridge.controller

import com.hercute.mcrabe.domain.cart.dto.ItemListToSomething
import com.hercute.mcrabe.domain.fridge.dto.CreateFridgeRequest
import com.hercute.mcrabe.domain.fridge.dto.FridgeResponse
import com.hercute.mcrabe.domain.fridge.dto.UpdateFridgeRequest
import com.hercute.mcrabe.domain.fridge.service.FridgeService
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fridges")
class FridgeController(
    private val fridgeService: FridgeService
) {

    @PostMapping
    fun createItemInFridge(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @RequestBody request: CreateFridgeRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(fridgeService.createItemInFridge(userPrincipal.id, request))
    }

    @PutMapping("/{fridgeId}")
    fun updateItemOfFridge(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable fridgeId: Long,
        @RequestBody request: UpdateFridgeRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(fridgeService.updateItemOfFridge(userPrincipal.id, fridgeId, request))
    }

    @DeleteMapping()
    fun deleteItemOfFridge(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @RequestParam request: ItemListToSomething
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(fridgeService.deleteItemOfFridge(userPrincipal.id, request))
    }

    @GetMapping("/{fridgeId}")
    fun getItemOfFridge(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable fridgeId: Long
    ): ResponseEntity<FridgeResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(fridgeService.getItemOfFridge(userPrincipal.id, fridgeId))
    }

    @GetMapping()
    fun getItemListOfFridge(
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
    ): ResponseEntity<List<FridgeResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(fridgeService.getItemListOfFridge(userPrincipal.id))
    }



}