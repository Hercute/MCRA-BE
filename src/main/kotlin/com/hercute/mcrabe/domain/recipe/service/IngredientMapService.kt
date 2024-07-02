package com.hercute.mcrabe.domain.recipe.service

import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.CreateIngredientMapRequest
import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.IngredientMapResponse
import com.hercute.mcrabe.domain.recipe.dto.ingredientMap.UpdateIngredientMapRequest
import org.springframework.data.domain.Page
import org.springframework.stereotype.Service

@Service
class IngredientMapService {
    fun createIngredientMap(recipeId:Long, request: CreateIngredientMapRequest) {}
    fun updateIngredientMap(ingredientMapId:Long, request: UpdateIngredientMapRequest) {}
    fun getIngredientMap(ingredientMapId:Long) : IngredientMapResponse {
        TODO()
    }
    fun getIngredientMapList() : Page<IngredientMapResponse>{
        TODO()
    }
    fun deleteIngredientMap(ingredientMapId:Long){}
}