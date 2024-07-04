package com.hercute.mcrabe.domain.members.controller

import com.hercute.mcrabe.domain.members.dto.*
import com.hercute.mcrabe.domain.members.entity.MemberRole
import com.hercute.mcrabe.domain.members.service.MemberService
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.Authentication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/members")
@RestController
class MemberController(
    val memberService: MemberService
) {
    // 구현하려는 기능 목록(괄호 안은 구현된 함수 이름)
    // 회원가입(signUp)
    // **이메일 인증**
    // 로그인(login)
    // **소셜로그인**
    // 로그아웃(백엔드에서는 미구현)
    // 회원 탈퇴(unregister)
    // 회원 차단(blockmember)
    // 재가입(rejoin)
    // 프로필 조회(getProfile)
    // 프로필 업데이트(updateProfile)
    // 좋아요 목록 조회
    // 소셜 유저 확인(issocial)
    // 비밀번호 확인(verifyCurrentPassword)
    // 이 중 회원 차단, 소셜 유저 확인은 AdminMemberController로 구성함
    @PostMapping("/signup")
    fun signUp(
        @Valid @RequestBody memberRequest: MemberRequest,
    ): ResponseEntity<Unit>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.signUp(memberRequest, MemberRole.MEMBER))
    }

    @PostMapping("/login")
    fun login(
            @RequestBody loginRequest: LoginRequest,
    ): ResponseEntity<LoginResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.login(loginRequest))
    }

    @GetMapping("{/memberId}")
    fun getProfile(
            @PathVariable memberId : Long
    ): ResponseEntity<MemberResponse>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.getProfile(memberId))
    }
    @PutMapping("/update")
    fun updateProfile(
        @RequestParam nickname : String,
        @RequestParam introduce : String,
        @AuthenticationPrincipal userPrincipal: UserPrincipal
    ): ResponseEntity<Unit>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.updateProfile(nickname, introduce, userPrincipal.id))
    }

    @PutMapping("/{memberId}/block")
    fun blockMember(@PathVariable memberId: Long
    ): ResponseEntity<Unit>{
        memberService.blockMember(memberId)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
    @DeleteMapping("/unregister")
    fun unregister(
        authentication: Authentication
    ): ResponseEntity<Unit> {
        val user = authentication.principal as UserPrincipal
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.unregister(user))
    }

    // 재가입 기능, 혹시 몰라 작성
    @PutMapping("/rejoin")
    fun rejoin(
        @RequestBody loginRequest: LoginRequest
    ): ResponseEntity<Unit>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.rejoin(loginRequest))
    }



    @PostMapping("/verify-password")
    fun verifyCurrentPassword(
        @RequestParam currentPassword : String,
        @AuthenticationPrincipal userPrincipal: UserPrincipal,
    ): ResponseEntity<VerifyCurrentPasswordREsponse>{
        // 도달 여부 확인을 위한 출력문
        println("백엔드 도달")
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(memberService.verifyCurrentPassword(currentPassword, userPrincipal.id))
    }
}