package com.hercute.mcrabe.domain.recipe.dto.ingredientMap

import com.hercute.mcrabe.domain.recipe.model.IngredientMap

data class IngredientMapResponse(
    val id: Long,
    val quantity: String,
    val recipeId: Long,
    val name: String,
) {
    companion object {
        fun from(ingredientMap: IngredientMap): IngredientMapResponse {
            val recipeId = ingredientMap.recipe.id!!
            val name = ingredientMap.ingredient.name
            return IngredientMapResponse(
                id = ingredientMap.id!!,
                quantity = ingredientMap.quantity,
                recipeId = recipeId,
                name = name
            )
        }
    }
}

