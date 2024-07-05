package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.IngredientMapResponse
import com.hercute.mcrabe.domain.recipe.dto.recipe.CreateRecipeRequest
import com.hercute.mcrabe.domain.recipe.dto.recipe.RecipeResponse
import com.hercute.mcrabe.domain.recipe.dto.recipe.UpdateRecipeRequest
import com.hercute.mcrabe.domain.recipe.dto.step.StepResponse
import com.hercute.mcrabe.domain.recipe.dto.tagMap.TagMapResponse
import com.hercute.mcrabe.domain.recipe.repository.RecipeRepository
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl(
    private val recipeRepository: RecipeRepository,
) : RecipeService {
    override fun createRecipe(memberId: Long, request: CreateRecipeRequest) {
        TODO("Not yet implemented")
    }

    override fun updateRecipe(recipeId: Long, request: UpdateRecipeRequest) {
        TODO("Not yet implemented")
    }

    override fun getRecipe(recipeId: Long): RecipeResponse {
        val recipe = recipeRepository.findByIdOrNull(recipeId)?:
            throw ModelNotFoundException("Recipe", recipeId)

        val stepList = recipe.StepList.map{step->
            StepResponse.from(step)
        }

        val tagMapList = recipe.TagMapList.map{ tagMap->
            TagMapResponse.from(tagMap)
        }
        val ingredientMapList = recipe.ingredientMapList.map{ ingredientMap->
            IngredientMapResponse.from(ingredientMap)
        }
        return RecipeResponse.from(recipe, stepList, tagMapList, ingredientMapList)
    }

    override fun getRecipeList(): Page<RecipeResponse> {
        TODO("Not yet implemented")
    }

    override fun deleteRecipe(recipeId: Long) {
        TODO("Not yet implemented")
    }
}