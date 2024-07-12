package com.hercute.mcrabe.domain.chat.chatroom.service

import com.hercute.mcrabe.domain.chat.chatroom.dto.ChatRoomResponse
import com.hercute.mcrabe.domain.chat.chatroom.dto.SendMessageRequest
import com.hercute.mcrabe.domain.chat.chatroom.model.ChatMessage
import com.hercute.mcrabe.domain.chat.chatroom.model.ChatRoom
import com.hercute.mcrabe.domain.chat.chatroom.repository.message.ChatMessageRepository
import com.hercute.mcrabe.domain.chat.chatroom.repository.room.ChatRoomRepository
import com.hercute.mcrabe.domain.members.repository.MemberRepository
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ChatRoomServiceImpl(
    private val memberRepository: MemberRepository,
    private val chatRoomRepository: ChatRoomRepository,
    private val chatMessageRepository: ChatMessageRepository
):ChatRoomService {
    override fun createChatRoom(memberAId: Long, memberBId: Long) {
        val memberA = memberRepository.findByIdOrNull(memberAId)
            ?: throw ModelNotFoundException("member", memberAId)
        val memberB = memberRepository.findByIdOrNull(memberBId)
            ?: throw ModelNotFoundException("member", memberBId)
        val chatRoom = ChatRoom(
            memberA = memberA,
            memberB = memberB
        )
        chatRoomRepository.save(chatRoom)
    }

    override fun leaveChatRoom(memberId: Long, chatRoomId: Long) {
        val member = memberRepository.findByIdOrNull(memberId)
            ?: throw ModelNotFoundException("member", memberId)
        val chatRoom = chatRoomRepository.findByIdOrNull(chatRoomId)
            ?: throw ModelNotFoundException("chat room", chatRoomId)
        if (chatRoom.memberA.id == member.id) {
            chatRoom.memberA.isDeleted = true
        }
        else if (chatRoom.memberB.id == member.id) {
            chatRoom.memberB.isDeleted = true
        }
        chatRoomRepository.save(chatRoom)
    }

    override fun getChatRoom(chatRoomId: Long): ChatRoomResponse {
        val chatRoom = chatRoomRepository.findByIdOrNull(chatRoomId)
            ?: throw ModelNotFoundException("chat room", chatRoomId)
        return ChatRoomResponse.from(chatRoom)
    }

    override fun sendMessage(memberId: Long, chatRoomId: Long, request: SendMessageRequest) {
        val member = memberRepository.findByIdOrNull(memberId)
            ?: throw ModelNotFoundException("member", memberId)
        val chatRoom = chatRoomRepository.findByIdOrNull(chatRoomId)
            ?: throw ModelNotFoundException("chat room", chatRoomId)
        val message = ChatMessage (
            member = member,
            chatRoom = chatRoom,
            message = request.message
        )
        chatMessageRepository.save(message)
    }
}