package com.hercute.mcrabe.domain.fridge.dto

import com.hercute.mcrabe.domain.fridge.model.Storage
import java.sql.Timestamp

data class FridgeResponse(
    val id: Long,
    val categoryId: Long,
    val memberId: Long,
    val name: String,
    val expirationDate: Timestamp,
    val memo: String,
    val storage: Storage
)
