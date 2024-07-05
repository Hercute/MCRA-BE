package com.hercute.mcrabe.domain.recipe.dto.recipe

data class UpdateRecipeRequest (

    val title:String,
    val name:String,
    val comment:String,
    val servings:Int,
    val time:Int,
    val likeCounts:Int,
    val image:String,

)
