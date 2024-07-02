package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.recipe.CreateRecipeRequest
import com.hercute.mcrabe.domain.recipe.dto.recipe.RecipeResponse
import com.hercute.mcrabe.domain.recipe.dto.recipe.UpdateRecipeRequest
import com.hercute.mcrabe.domain.recipe.service.IngredientMapService
import com.hercute.mcrabe.domain.recipe.service.TagMapService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
class TagMapController (
    private val tagMapService: TagMapService
) {
    //@Operation(summary = "레시피 생성")
    @Transactional
    @PostMapping("/create")
    fun createRecipe(
        @RequestParam memberId : Long,
        @Valid @RequestBody request: CreateRecipeRequest,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(tagMapService.createRecipe(memberId, request))
    }

    //@Operation(summary = "레시피 단건 조회")
    @Transactional
    @GetMapping("/{RecipeId}")
    fun getRecipe(
        @RequestParam memberId : Long,
    ): ResponseEntity<RecipeResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagMapService.getRecipe(memberId))
    }

    //@Operation(summary = "레시피 통합 조회")
    @Transactional
    @GetMapping("/allRecipeList")
    fun getRecipeList(
        @Valid @RequestBody request: CreateRecipeRequest
        // 조회 조건 추가 필요
    ): ResponseEntity<Page<RecipeResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagMapService.getRecipeList())
    }

    @Transactional
    @PutMapping("/{recipeId}")
    fun UpdateRecipeList(
        @PathVariable recipeId : Long,
        @Valid @RequestBody request: UpdateRecipeRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(tagMapService.updateRecipe(recipeId, request))
    }

    @Transactional
    @DeleteMapping("/{recipeId}")
    fun DeleteRecipeList(
        @PathVariable recipeId : Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(tagMapService.deleteRecipe(recipeId))
    }
}