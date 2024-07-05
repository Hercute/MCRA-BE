package com.hercute.mcrabe.domain.members.controller

import com.hercute.mcrabe.domain.members.repository.ProviderMapRepository
import com.hercute.mcrabe.domain.members.service.MemberService
import com.hercute.mcrabe.global.infra.security.jwt.JwtPlugin
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/members")
class AdminMemberController(private val memberService: MemberService,

) {

    @PutMapping("/{memberId}/block")
    fun blockMember(@PathVariable memberId: Long): ResponseEntity<Unit> {
        memberService.blockMember(memberId)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
    @GetMapping("/issocial")
    fun issocial(
        @AuthenticationPrincipal userPrincipal: UserPrincipal
    ): ResponseEntity<Boolean>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.isSocial(userPrincipal))
    }
}