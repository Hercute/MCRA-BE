package com.hercute.mcrabe.domain.recipe.dto.ingredient

import com.hercute.mcrabe.domain.recipe.model.Ingredient

data class IngredientResponse(
    val id:Long,
    val name:String,
){
    companion object {
        fun from(ingredient:Ingredient): IngredientResponse {
            return IngredientResponse(
                id = ingredient.id!!,
                name = ingredient.name,
            )
        }
    }
}

