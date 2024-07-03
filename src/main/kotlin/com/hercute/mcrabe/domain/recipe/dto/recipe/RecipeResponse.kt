package com.hercute.mcrabe.domain.recipe.dto.recipe

import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.IngredientMapResponse
import com.hercute.mcrabe.domain.recipe.dto.tagMap.TagMapResponse
import com.hercute.mcrabe.domain.recipe.model.Recipe
import com.hercute.mcrabe.domain.recipe.service.RecipeService

data class RecipeResponse(
    val id:Long,

    val title:String,
    val name:String,
    val comment:String,
    val servings:Int,
    val time:Int,
    val likeCounts:Int,
    val image:String,

    val tagMapList: List<TagMapResponse>,
    val ingredientMapList: List<IngredientMapResponse>
){
    companion object {
        fun from(recipe: Recipe, tagMapList : List<TagMapResponse>, ingredientMapList : List<IngredientMapResponse>): RecipeResponse {
            return RecipeResponse(
                id = recipe.id!!,
                title = recipe.title,
                name = recipe.name,
                comment = recipe.comment,
                servings = recipe.servings,
                time = recipe.time,
                likeCounts = recipe.likeCounts,
                image = recipe.image,
                tagMapList = tagMapList,
                ingredientMapList = ingredientMapList,
            )
        }
    }
}