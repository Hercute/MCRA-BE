package com.hercute.mcrabe.domain.chat.chatroom.controller

import com.hercute.mcrabe.domain.chat.chatroom.dto.ChatRoomResponse
import com.hercute.mcrabe.domain.chat.chatroom.dto.SendMessageRequest
import com.hercute.mcrabe.domain.chat.chatroom.service.ChatRoomService
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chats")
class ChatRoomController(
    private val chatRoomService: ChatRoomService
) {

    @PostMapping
    fun createChatRoom (
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @RequestParam memberId: Long
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(chatRoomService.createChatRoom(userPrincipal.id, memberId))
    }

    @DeleteMapping("/{chatRoomId}")
    fun leaveChatRoom (
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable chatRoomId: Long,
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(chatRoomService.leaveChatRoom(userPrincipal.id, chatRoomId))
    }

    @GetMapping("/{chatRoomId}")
    fun getChatRoom (
        @PathVariable chatRoomId: Long,
    ): ResponseEntity<ChatRoomResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(chatRoomService.getChatRoom(chatRoomId))
    }

    @PostMapping("/{chatRoomId}")
    fun sendMessage (
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
        @PathVariable chatRoomId: Long,
        @RequestBody request: SendMessageRequest
    ): ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(chatRoomService.sendMessage(userPrincipal.id, chatRoomId, request))
    }
}