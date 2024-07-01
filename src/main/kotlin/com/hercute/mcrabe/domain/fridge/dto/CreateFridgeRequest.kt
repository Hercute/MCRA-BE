package com.hercute.mcrabe.domain.fridge.dto

import com.hercute.mcrabe.domain.fridge.model.Storage
import java.sql.Timestamp

data class CreateFridgeRequest(
    val categoryId: Long,
    val name: String,
    val expirationDate: Timestamp,
    val memo: String,
    val storage: Storage
)
