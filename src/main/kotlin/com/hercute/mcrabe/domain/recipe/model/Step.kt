package com.hercute.mcrabe.domain.recipe.model

import jakarta.persistence.*

@Entity
class Step(
    val num : Int,
    val comment : String,
    val image : String,

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    val recipe : Recipe
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
}