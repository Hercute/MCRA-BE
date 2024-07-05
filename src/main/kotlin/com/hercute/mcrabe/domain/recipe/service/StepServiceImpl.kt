package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.step.CreateStepRequest
import com.hercute.mcrabe.domain.recipe.dto.step.StepResponse
import com.hercute.mcrabe.domain.recipe.dto.step.UpdateStepRequest
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class StepServiceImpl : StepService {
    override fun createStep(recipeId: Long, request: CreateStepRequest) {
        TODO("Not yet implemented")
    }

    override fun updateStep(recipeId: Long, request: UpdateStepRequest) {
        TODO("Not yet implemented")
    }

    override fun getStep(recipeId: Long): StepResponse {
        TODO("Not yet implemented")
    }

    override fun getStepList(): Page<StepResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteStep(recipeId: Long) {
        TODO("Not yet implemented")
    }
}