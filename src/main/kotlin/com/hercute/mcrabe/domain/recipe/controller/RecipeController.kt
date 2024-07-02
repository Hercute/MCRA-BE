package com.hercute.mcrabe.domain.recipe.controller

import com.hercute.mcrabe.domain.recipe.dto.CreateRecipeRequest
import com.hercute.mcrabe.domain.recipe.dto.RecipeResponse
import com.hercute.mcrabe.domain.recipe.dto.UpdateRecipeRequest
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
    @PostMapping("/create")
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
    @GetMapping("/{RecipeId}")
    fun getRecipe(
        @RequestParam memberId : Long,
    ): ResponseEntity<RecipeResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(recipeService.getRecipe(memberId))
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
            .body(recipeService.getRecipeList())
    }

    @Transactional
    @PutMapping("/{recipeId}")
    fun UpdateRecipeList(
        @PathVariable recipeId : Long,
        @Valid @RequestBody request: UpdateRecipeRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(recipeService.updateRecipe(recipeId, request))
    }

    @Transactional
    @DeleteMapping("/{recipeId}")
    fun DeleteRecipeList(
        @PathVariable recipeId : Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(recipeService.deleteRecipe(recipeId))
    }



}