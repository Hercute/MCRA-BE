package com.hercute.mcrabe.domain.recipe.dto

data class RecipeIngredientMapResponse (
    val id:Long,
    val quantity : String,
    val recipeId: Long,
    val ingredient : String,
)
