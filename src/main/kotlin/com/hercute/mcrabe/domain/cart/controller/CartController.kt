package com.hercute.mcrabe.domain.cart.controller

import com.hercute.mcrabe.domain.cart.dto.AddItemInCartRequest
import com.hercute.mcrabe.domain.cart.dto.ItemListToSomething
import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.dto.UpdateItemInCartRequest
import com.hercute.mcrabe.domain.cart.service.CartService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
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
@RequestMapping("/carts")
class CartController(
    private val cartService: CartService
) {

    @PostMapping
    fun addItemInCart(
//        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @RequestBody request: AddItemInCartRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(cartService.addItemInCart(request))
    }

    @PutMapping("/{itemId}")
    fun updateItemOfCart(
//        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable itemId: Long,
        @RequestBody request: UpdateItemInCartRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.updateItemOfCart(itemId, request))
    }

    @DeleteMapping("")
    fun deleteItemOfCart(
//        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @RequestParam request: ItemListToSomething
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(cartService.deleteItemOfCart(request))
    }

    @GetMapping("/{itemId}")
    fun getItemOfCart(
//        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable itemId: Long
    ): ResponseEntity<ItemResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.getItemOfCart(itemId))
    }

    @GetMapping
    fun getItemList(
        @PageableDefault(size = 5, sort = ["id"]) pageable: Pageable,
//        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @RequestParam(required = false) purchasedDate: Timestamp?
    ): ResponseEntity<Page<ItemResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.getItemList(pageable, purchasedDate))
    }

    @GetMapping("/records")
    fun getCartRecords(
//        @AuthenticationPrincipal userPrincipal: UserPrincipal,
    ): ResponseEntity<List<ItemResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.getCartRecords())
    }

    @PutMapping("/purchase")
    fun checkItemPurchaseStatus(
        @RequestBody request: ItemListToSomething
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.checkItemPurchaseStatus(request))
    }

    @PutMapping("/move")
    fun moveItemToFridge(
    //        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        request: ItemListToSomething
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(cartService.moveItemToFridge(request))
    }
}