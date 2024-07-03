package com.hercute.mcrabe.domain.members.service

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.stereotype.Service

@Service
class OAuth2UserService(
    private val memberService: MemberService
): DefaultOAuth2UserService() {

}