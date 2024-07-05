package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.recipe.CreateRecipeRequest
import com.hercute.mcrabe.domain.recipe.dto.recipe.RecipeResponse
import com.hercute.mcrabe.domain.recipe.dto.recipe.UpdateRecipeRequest
import com.hercute.mcrabe.domain.recipe.service.RecipeService
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/recipes")
class RecipeController(
    private val recipeService : RecipeService
) {
    //@Operation(summary = "레시피 생성")
    @Transactional
    @PostMapping
    fun createRecipe(
        @RequestParam memberId : Long,
        @Valid @RequestBody request: CreateRecipeRequest,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(recipeService.createRecipe(memberId, request))
    }

    //@Operation(summary = "레시피 단건 조회")
    @Transactional
    @GetMapping("/{recipeId}")
    fun getRecipe(
        @PathVariable recipeId:Long,
    ): ResponseEntity<RecipeResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(recipeService.getRecipe(recipeId))
    }

    //@Operation(summary = "레시피 통합 조회")
    @Transactional
    @GetMapping("/recipeList")
    fun getRecipeList(
        // 조회 조건 추가 필요
    ): ResponseEntity<Page<RecipeResponse>> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(recipeService.getRecipeList())
    }

    @Transactional
    @PutMapping("/{recipeId}")
    fun updateRecipe(
        @PathVariable recipeId : Long,
        @Valid @RequestBody request: UpdateRecipeRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(recipeService.updateRecipe(recipeId, request))
    }

    @Transactional
    @DeleteMapping("/{recipeId}")
    fun deleteRecipe(
        @PathVariable recipeId : Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(recipeService.deleteRecipe(recipeId))
    }
}