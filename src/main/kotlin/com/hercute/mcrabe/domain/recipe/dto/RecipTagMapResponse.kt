package com.hercute.mcrabe.domain.recipe.dto

data class RecipeTagMapResponse(
    val id:Long,
    val recipeId: Long,
    val tag : String,
)
