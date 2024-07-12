package com.hercute.mcrabe.domain.chat.chatroom.repository.room

import com.hercute.mcrabe.domain.chat.chatroom.model.ChatRoom
import org.springframework.data.jpa.repository.JpaRepository

interface ChatRoomRepository:JpaRepository<ChatRoom, Long> {
}