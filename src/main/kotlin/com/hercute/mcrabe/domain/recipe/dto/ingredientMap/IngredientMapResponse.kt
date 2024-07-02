package com.hercute.mcrabe.domain.recipe.dto.ingredientMap

data class IngredientMapResponse (
    val id:Long,
    val quantity : String,
    val recipeId: Long,
    val name : String,
)
