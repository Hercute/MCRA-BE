package com.hercute.mcrabe.domain.recipe.dto
data class RecipeResponse(
    val id:Long,

    val title:String,
    val name:String,
    val comment:String,
    val servings:Int,
    val time:Int,
    val likeCounts:Int,
    val image:String,

    val recipeTagMaps: List<RecipeTagMapResponse>,
    val recipeIngredientMaps: List<RecipeIngredientMapResponse>
)