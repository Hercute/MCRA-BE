package com.hercute.mcrabe.domain.recipe.dto.step

import com.hercute.mcrabe.domain.recipe.model.Step

data class StepResponse(
    val num : Int,
    val comment : String,
    val image : String,
){
    companion object{
        fun from(step : Step):StepResponse{
            return StepResponse(
                num = step.num,
                comment = step.comment,
                image = step.image
            )
        }
    }
}
