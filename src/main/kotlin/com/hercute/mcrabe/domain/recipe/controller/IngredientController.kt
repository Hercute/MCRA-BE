package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.ingredient.CreateIngredientRequest
import com.hercute.mcrabe.domain.recipe.dto.ingredient.IngredientResponse
import com.hercute.mcrabe.domain.recipe.dto.ingredient.UpdateIngredientRequest
import com.hercute.mcrabe.domain.recipe.service.IngredientService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ingredients")
class IngredientController(

    private val ingredientService: IngredientService
) {
    //@Operation(summary = "레시피 생성")
    @Transactional
    @PostMapping
    fun createIngredient(
        @Valid @RequestBody request: CreateIngredientRequest,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ingredientService.createIngredient(request))
    }

    //@Operation(summary = "레시피 단건 조회")
    @Transactional
    @GetMapping("/{ingredientId}")
    fun getIngredient(
        @PathVariable ingredientId: Long,
    ): ResponseEntity<IngredientResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ingredientService.getIngredient(ingredientId))
    }

    //@Operation(summary = "레시피 통합 조회")
    @Transactional
    @GetMapping("/ingredientList")
    fun getIngredientList(
        // 조회 조건 추가 필요
    ): ResponseEntity<Page<IngredientResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ingredientService.getIngredientList())
    }

    @Transactional
    @PutMapping("/{ingredientId}")
    fun updateIngredient(
        @PathVariable ingredientId: Long,
        @Valid @RequestBody request: UpdateIngredientRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ingredientService.updateIngredient(ingredientId, request))
    }

    @Transactional
    @DeleteMapping("/{ingredientId}")
    fun deleteIngredient(
        @PathVariable ingredientId: Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(ingredientService.deleteIngredient(ingredientId))
    }
}