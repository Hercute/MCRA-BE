package com.hercute.mcrabe.domain.recipe.dto.tagMap

import com.hercute.mcrabe.domain.recipe.model.TagMap

data class TagMapResponse(
    val id:Long,
    val recipeId: Long,
    val name : String,
){
    companion object{
        fun from(tagMap : TagMap): TagMapResponse {
            val recipeId = tagMap.recipe.id
            val name = tagMap.tag.name
            return TagMapResponse(
                id = tagMap.id!!,
                recipeId = recipeId!!,
                name = name
            )
        }
    }
}
