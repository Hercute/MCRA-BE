package com.hercute.mcrabe.domain.fridge.dto

import com.hercute.mcrabe.domain.fridge.model.Fridge
import com.hercute.mcrabe.domain.fridge.model.Storage
import java.sql.Timestamp

data class FridgeResponse(
    val id: Long,
//    val categoryId: Long,
//    val memberId: Long,
    val name: String,
    val expirationDate: Timestamp,
    val memo: String,
    val storage: Storage
) {
    companion object {
        fun from(fridge: Fridge): FridgeResponse{
            return FridgeResponse (
                id = fridge.id!!,
//                categoryId = fridge.category.id,
//                memberId = fridge.member.id,
                name = fridge.name,
                expirationDate = fridge.expirationDate!!,
                memo = fridge.memo,
                storage = fridge.storage
            )
        }
    }
}
