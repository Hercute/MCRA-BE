package com.hercute.mcrabe.domain.recipe.model

import jakarta.persistence.*


@Entity
class Recipe(
    val title:String,
    val name:String,
    val comment:String,
    val servings:Int,
    val time:Int,
    val likeCounts:Int,
    val image:String,

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    val member:Member, // 1:N
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
    val recipeTagMaps: MutableList<RecipeTagMap> = mutableListOf()

    @OneToMany(mappedBy = "recipe", cascade = [CascadeType.ALL], orphanRemoval = true)
    val recipeIngredientMaps: MutableList<RecipeIngredientMap> = mutableListOf()
}