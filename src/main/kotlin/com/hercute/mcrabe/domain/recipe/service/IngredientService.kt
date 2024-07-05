package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.ingredient.CreateIngredientRequest
import com.hercute.mcrabe.domain.recipe.dto.ingredient.IngredientResponse
import com.hercute.mcrabe.domain.recipe.dto.ingredient.UpdateIngredientRequest
import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.CreateIngredientMapRequest
import com.hercute.mcrabe.domain.recipe.dto.tag.CreateTagRequest
import com.hercute.mcrabe.domain.recipe.dto.tag.TagResponse
import com.hercute.mcrabe.domain.recipe.dto.tag.UpdateTagRequest
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class IngredientService {
    fun createIngredient(request: CreateIngredientRequest){}
    fun updateIngredient(ingredientId: Long, request: UpdateIngredientRequest){}
    fun getIngredient(ingredientId:Long) : IngredientResponse {
        TODO()
    }
    fun getIngredientList() : Page<IngredientResponse> {
        TODO()
    }
    fun deleteIngredient(ingredientId: Long){}

}