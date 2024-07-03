package com.hercute.mcrabe.domain.members.dto

import jakarta.validation.constraints.Size

data class UpdateProfileRequest(
    @field: Size(min = 2, max = 12, message = " Nickname must be between 2 and 12 characters")
    val nickname : String,

    val introduce : String,
)