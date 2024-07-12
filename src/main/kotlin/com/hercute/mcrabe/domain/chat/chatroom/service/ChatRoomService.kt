package com.hercute.mcrabe.domain.chat.chatroom.service

import com.hercute.mcrabe.domain.chat.chatroom.dto.ChatRoomResponse
import com.hercute.mcrabe.domain.chat.chatroom.dto.SendMessageRequest
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal

interface ChatRoomService {
    fun createChatRoom(memberAId: Long, memberBId: Long)

    fun leaveChatRoom(memberId: Long, chatRoomId: Long)

    fun getChatRoom(chatRoomId: Long): ChatRoomResponse

    fun sendMessage(memberId: Long, chatRoomId: Long, request: SendMessageRequest)
}