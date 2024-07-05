package com.hercute.mcrabe.domain.recipe.repository

import com.hercute.mcrabe.domain.recipe.model.Recipe
import org.springframework.data.jpa.repository.JpaRepository

interface RecipeRepository : JpaRepository<Recipe, Long>  {
}