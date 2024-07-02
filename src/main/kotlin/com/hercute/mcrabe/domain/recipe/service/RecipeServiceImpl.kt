package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.recipe.CreateRecipeRequest
import com.hercute.mcrabe.domain.recipe.dto.recipe.RecipeResponse
import com.hercute.mcrabe.domain.recipe.dto.recipe.UpdateRecipeRequest
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl() : RecipeService {
    override fun createRecipe(memberId: Long, request: CreateRecipeRequest) {
        TODO("Not yet implemented")
    }

    override fun updateRecipe(recipeId: Long, request: UpdateRecipeRequest) {
        TODO("Not yet implemented")
    }

    override fun getRecipe(recipeId: Long): RecipeResponse {
        TODO("Not yet implemented")
    }

    override fun getRecipeList(): Page<RecipeResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteRecipe(recipeId: Long) {
        TODO("Not yet implemented")
    }
}