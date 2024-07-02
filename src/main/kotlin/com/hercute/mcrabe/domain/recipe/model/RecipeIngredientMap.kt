package com.hercute.mcrabe.domain.recipe.model

import jakarta.persistence.*

@Entity
class RecipeIngredientMap  (

    val quantity : String,

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    val recipe : Recipe, // N:1

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    val ingredient : Ingredient, // N:1

){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
}