package com.hercute.mcrabe.domain.recipe.repository

import com.hercute.mcrabe.domain.recipe.model.IngredientMap
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientMapRepository : JpaRepository<IngredientMap, Long> {
}