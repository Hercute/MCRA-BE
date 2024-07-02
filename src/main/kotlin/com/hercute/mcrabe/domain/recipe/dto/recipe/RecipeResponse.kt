package com.hercute.mcrabe.domain.recipe.dto.recipe

import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.IngredientMapResponse
import com.hercute.mcrabe.domain.recipe.dto.tagMap.TagMapResponse

data class RecipeResponse(
    val id:Long,

    val title:String,
    val name:String,
    val comment:String,
    val servings:Int,
    val time:Int,
    val likeCounts:Int,
    val image:String,

    val recipeTagMaps: List<TagMapResponse>,
    val recipeIngredientMaps: List<IngredientMapResponse>
)