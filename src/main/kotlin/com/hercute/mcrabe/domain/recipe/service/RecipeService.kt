package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.CreateRecipeRequest
import com.hercute.mcrabe.domain.recipe.dto.RecipeResponse
import com.hercute.mcrabe.domain.recipe.dto.UpdateRecipeRequest
import org.springframework.data.domain.Page


interface RecipeService {
    fun createRecipe(memberId:Long, request:CreateRecipeRequest)
    fun updateRecipe(recipeId:Long, request: UpdateRecipeRequest)
    fun getRecipe(recipeId:Long) : RecipeResponse
    fun getRecipeList() : Page<RecipeResponse>
    fun deleteRecipe(recipeId:Long)

}