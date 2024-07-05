package com.hercute.mcrabe.domain.recipe.dto.step

data class UpdateStepRequest(
    val num : Int,
    val comment : String,
    val image : String,
)