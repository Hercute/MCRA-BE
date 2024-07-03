package com.hercute.mcrabe.domain.members.service

import com.hercute.mcrabe.domain.members.dto.*
import com.hercute.mcrabe.domain.members.entity.Member
import com.hercute.mcrabe.domain.members.entity.MemberRole
import com.hercute.mcrabe.domain.members.entity.Provider
import com.hercute.mcrabe.domain.members.entity.ProviderMap
import com.hercute.mcrabe.domain.members.repository.MemberRepository
import com.hercute.mcrabe.domain.members.repository.ProviderMapRepository
import com.hercute.mcrabe.global.error.exception.InvalidCredentialException
import com.hercute.mcrabe.global.infra.security.jwt.JwtPlugin
import com.hercute.mcrabe.global.infra.security.jwt.UserPrincipal
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberServiceImpl (
    private val memberRepository: MemberRepository,
    private val providerMapRepository: ProviderMapRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtPlugin: JwtPlugin
) : MemberService{
    @Transactional
    override fun signUp(memberRequest: MemberRequest, role: MemberRole) {
        memberRepository.findByEmail(memberRequest.email)
            ?.let {
                providerMapRepository.fineByMemberId(it.id!!)
                    .run {
                        check(!this.isCommonMember)
                        this.registerSocialInfo(Provider.COMMON)
                        it.password = passwordEncoder.encode((memberRequest.password))
                        it.nickname = memberRequest.nickname
                        it.introduce = memberRequest.introduce
                    }
            }
            ?: memberRepository.save(
                Member(
                    email = memberRequest.email,
                    nickname = memberRequest.nickname,
                    introduce = memberRequest.introduce,
                    password = passwordEncoder.encode(memberRequest.password),
                    role = role,
                )
            ).let {
                providerMapRepository.save(
                    ProviderMap(
                        memberId = it.id!!
                    )
                ).registerSocialInfo(Provider.COMMON)
            }
    }
    override fun login(loginRequest: LoginRequest): LoginResponse {
        val member = memberRepository.findByEmail(loginRequest.email)
            ?: throw  InvalidCredentialException("")
        check(providerMapRepository.fineByMemberId(member.id!!).isCommonMember)

        if (!passwordEncoder.matches(loginRequest.password, member.password))
            throw InvalidCredentialException("")

        return LoginResponse(
            token = jwtPlugin.generateAccessToken(
                subject = member.id.toString(),
                email = member.email,
                role = member.role.name
            )
        )
    }
    override fun socialLogin(userInfo: OAuth2UserInfo): LoginResponse {
        val member = memberRepository.findByEmail(userInfo.email)
            ?: throw InvalidCredentialException("")
        return LoginResponse(
            jwtPlugin.generateAccessToken(
                subject = member.id.toString(),
                email = member.email,
                role = member.role.name
            )
        )
    }
    @Transactional
    override fun socialSignUpOrLogin(userInfo: OAuth2UserInfo): Any? {
        val provider = Provider.valueOf(userInfo.provider)
        return memberRepository.findByEmail(userInfo.email)
            ?.let { providerMapRepository.fineByMemberId(it.id!!).registerSocialInfo(provider) }
            ?: memberRepository.save(socialSignUpAndRegister(userInfo.id,userInfo.nickname, userInfo.email, userInfo.introduce, provider))
    }
    override fun socialSignUpAndRegister(id: String, nickname: String, email: String, introduce: String, provider: Provider): Member {
        TODO("Not yet implemented")
    }
    override fun getProfile(memberId: Long): MemberResponse {
        TODO("Not yet implemented")
    }
    @Transactional
    override fun updateProfile(nickname: String, introduce: String, memberId: Long) {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun unregister(user: UserPrincipal) {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun rejoin(loginRequest: LoginRequest) {
        TODO("Not yet implemented")
    }

    override fun isSocial(userPrincipal: UserPrincipal): Boolean {
        TODO("Not yet implemented")
    }

    override fun verifyCurrentPassword(currentPassword: String, memberId: Long): VerifyCurrentPasswordREsponse {
        TODO("Not yet implemented")
    }
}