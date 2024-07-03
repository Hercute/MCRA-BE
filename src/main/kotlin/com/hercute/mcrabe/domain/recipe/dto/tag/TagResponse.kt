package com.hercute.mcrabe.domain.recipe.dto.tag

import com.hercute.mcrabe.domain.recipe.dto.ingredient.IngredientResponse
import com.hercute.mcrabe.domain.recipe.model.Tag

data class TagResponse(
    val id:Long,
    val name:String,
){
    companion object {
        fun from(tag : Tag): TagResponse {
            return TagResponse(
                id = tag.id!!,
                name = tag.name
            )
        }
    }
}