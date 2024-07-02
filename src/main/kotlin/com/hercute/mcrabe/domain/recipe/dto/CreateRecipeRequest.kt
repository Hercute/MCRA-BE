package com.hercute.mcrabe.domain.recipe.dto

data class CreateRecipeRequest(
    val title:String,
    val name:String,
    val comment:String,
    val servings:Int,
    val time:Int,
    val likeCounts:Int,
    val image:String,
)
