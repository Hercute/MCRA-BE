package com.hercute.mcrabe.domain.members.service

import com.hercute.mcrabe.domain.members.dto.*
import com.hercute.mcrabe.domain.members.entity.Member
import com.hercute.mcrabe.domain.members.entity.MemberRole
import com.hercute.mcrabe.domain.members.entity.Provider
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface MemberService {
    fun signUp(memberRequest: MemberRequest, role : MemberRole)
    fun login(loginRequest: LoginRequest) : LoginResponse
    fun socialLogin(userInfo: OAuth2UserInfo) : LoginResponse
    fun socialSignUpOrLogin(userInfo: OAuth2UserInfo) : Any?
    fun socialSignUpAndRegister(id: String, nickname: String, email: String, introduce: String, provider: Provider) : Member
    fun getProfile(memberId: Long) : MemberResponse
    fun updateProfile(nickname: String, introduce: String, memberId: Long)

//    fun getLikeList(pageable: Pageable, memberId: Long?) : Page<LikeResponse>
    fun blockMember(memberId: Long)
    fun unregister(user: UserPrincipal)
    fun rejoin(loginRequest: LoginRequest)
    fun isSocial(userPrincipal: UserPrincipal) : Boolean
    fun verifyCurrentPassword(currentPassword : String, memberId: Long) : VerifyCurrentPasswordREsponse

}