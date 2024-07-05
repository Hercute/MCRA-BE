package com.hercute.mcrabe.domain.recipe.model

import jakarta.persistence.*

@Entity
class TagMap (

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    val recipe : Recipe, // N:1

    @ManyToOne
    @JoinColumn(name = "tag_id")
    val tag : Tag, // N:1

){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null
}