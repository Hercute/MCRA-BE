package com.hercute.mcrabe.domain.categories.dto

import com.hercute.mcrabe.domain.categories.model.Categories

data class CategoriesResponse(
    val main : String,
    val sub : String,
) {

    companion object {
        fun from(category: Categories): CategoriesResponse {
            return CategoriesResponse(
                main = category.main,
                sub = category.sub,
            )
        }
    }
}