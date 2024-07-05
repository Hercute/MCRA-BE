package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.step.CreateStepRequest
import com.hercute.mcrabe.domain.recipe.dto.step.StepResponse
import com.hercute.mcrabe.domain.recipe.dto.step.UpdateStepRequest
import org.springframework.data.domain.Page

interface StepService {
    fun createStep(recipeId: Long, request: CreateStepRequest)
    fun updateStep(recipeId:Long, request: UpdateStepRequest)
    fun getStep(recipeId:Long) : StepResponse
    fun getStepList() : Page<StepResponse>
    fun deleteStep(recipeId:Long)
}