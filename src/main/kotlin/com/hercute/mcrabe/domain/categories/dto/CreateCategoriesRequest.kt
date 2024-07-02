package com.hercute.mcrabe.domain.categories.dto

import jakarta.validation.constraints.NotBlank

data class CreateCategoriesRequest (
    @field: NotBlank
    val main : String,
    val sub : String,
)