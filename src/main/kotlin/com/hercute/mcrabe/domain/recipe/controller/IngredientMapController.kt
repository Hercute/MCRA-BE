package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.CreateIngredientMapRequest
import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.IngredientMapResponse
import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.UpdateIngredientMapRequest
import com.hercute.mcrabe.domain.recipe.service.IngredientMapService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ingredientMaps")
class IngredientMapController(
    private val ingredientMapService : IngredientMapService
) {
    //@Operation(summary = "레시피 생성")
    @Transactional
    @PostMapping
    fun createIngredientMap(
        @RequestParam recipeId: Long,
        @Valid @RequestBody request: CreateIngredientMapRequest,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(ingredientMapService.createIngredientMap(recipeId, request))
    }

    //@Operation(summary = "레시피 단건 조회")
    @Transactional
    @GetMapping("/{ingredientMapId}")
    fun getIngredientMap(
        @PathVariable ingredientMapId : Long,
    ): ResponseEntity<IngredientMapResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ingredientMapService.getIngredientMap(ingredientMapId))
    }

    //@Operation(summary = "레시피 통합 조회")
    @Transactional
    @GetMapping("/ingredientMapList")
    fun getIngredientMapList(
        // 조회 조건 추가 필요
    ): ResponseEntity<Page<IngredientMapResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ingredientMapService.getIngredientMapList())
    }

    @Transactional
    @PutMapping("/{ingredientMapId}")
    fun updateIngredientMap(
        @PathVariable ingredientMapId : Long,
        @Valid @RequestBody request: UpdateIngredientMapRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ingredientMapService.updateIngredientMap(ingredientMapId, request))
    }

    @Transactional
    @DeleteMapping("/{ingredientMapId}")
    fun deleteRecipeList(
        @PathVariable ingredientMapId : Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(ingredientMapService.deleteIngredientMap(ingredientMapId))
    }
}