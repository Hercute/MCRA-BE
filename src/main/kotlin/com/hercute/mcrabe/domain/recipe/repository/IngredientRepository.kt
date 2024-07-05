package com.hercute.mcrabe.domain.recipe.repository

import com.hercute.mcrabe.domain.recipe.model.Ingredient
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository: JpaRepository<Ingredient, Long> {
}