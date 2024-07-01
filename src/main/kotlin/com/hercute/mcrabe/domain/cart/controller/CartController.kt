package com.hercute.mcrabe.domain.cart.controller

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import com.hercute.mcrabe.domain.cart.service.CartService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp

@RestController
@RequestMapping("/{memberId}/carts")
class CartController(
    private val cartService: CartService
) {

    @PostMapping
    fun addItemInCart(
        @PathVariable memberId: Long,
        @RequestBody request: AddItemInCartRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(cartService.addItemInCart(memberId, request))
    }

    @PutMapping("/{itemId}")
    fun updateItemOfCart(
        @PathVariable memberId: Long,
        @PathVariable itemId: Long,
        @RequestBody request: UpdateItemInCartRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.updateItemOfCart(memberId, itemId, request))
    }

    @DeleteMapping("/{itemId}")
    fun deleteItemOfCart(
        @PathVariable memberId: Long,
        @PathVariable itemId: Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(cartService.deleteItemOfCart(memberId, itemId))
    }

    @GetMapping("/{itemId}")
    fun getItemOfCart(
        @PathVariable memberId: Long,
        @PathVariable itemId: Long
    ): ResponseEntity<ItemResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.getItemOfCart(memberId, itemId))
    }

    @GetMapping
    fun getItemList(
        @PathVariable memberId: Long,
        @RequestParam purchasedDate: Timestamp?
    ): ResponseEntity<List<ItemResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.getItemList(memberId, purchasedDate))
    }

    @GetMapping("/records")
    fun getCartRecords(
        @PathVariable memberId: Long,
    ): ResponseEntity<List<ItemResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.getCartRecords(memberId))
    }

    @PutMapping("/{itemId}/purchase")
    fun checkItemPurchaseStatus(
        @PathVariable memberId: Long,
        @PathVariable itemId: Long
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.checkItemPurchaseStatus(memberId, itemId))
    }

    @PutMapping("/move")
    fun moveItemToFridge(
        @PathVariable memberId: Long
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.moveItemToFridge(memberId))
    }
}