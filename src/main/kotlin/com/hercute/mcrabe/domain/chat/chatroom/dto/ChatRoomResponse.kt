package com.hercute.mcrabe.domain.chat.chatroom.dto

import com.hercute.mcrabe.domain.cart.dto.ItemResponse
import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.categories.model.Categories
import com.hercute.mcrabe.domain.chat.chatroom.model.ChatRoom

data class ChatRoomResponse(
    val id: Long,
    val memberA: Long?,
    val memberB: Long?,
){
    companion object {
        fun from(chatRoom: ChatRoom): ChatRoomResponse {
            return ChatRoomResponse (
                id = chatRoom.id!!,
                memberA = chatRoom.memberA.id,
                memberB = chatRoom.memberB.id
            )
        }
    }
}
