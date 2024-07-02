package com.hercute.mcrabe.domain.categories.dto

import jakarta.validation.constraints.NotBlank

data class UpdateCategoriesRequest (
    @field: NotBlank
    val main : String,
    val sub : String,
)