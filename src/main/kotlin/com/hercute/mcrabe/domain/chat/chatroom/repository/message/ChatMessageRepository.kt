package com.hercute.mcrabe.domain.chat.chatroom.repository.message

import com.hercute.mcrabe.domain.chat.chatroom.model.ChatMessage
import org.springframework.data.jpa.repository.JpaRepository

interface ChatMessageRepository: JpaRepository<ChatMessage, Long> {
}