package com.hercute.mcrabe.domain.members.service

import com.hercute.mcrabe.domain.members.dto.OAuth2UserInfo
import com.hercute.mcrabe.global.infra.security.jwt.JwtPlugin
// 아래 필터체인은 최초 override 시 2개가 생성되어 자동 삽입된 내용
// 해당 내용의 코드는 아래에 주석 처리해 두었음
import jakarta.servlet.FilterChain
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

class Oauth2LoginSuccessHandler (
    private val jwtPlugin: JwtPlugin,
    private val memberService: MemberService
): AuthenticationSuccessHandler{

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val userInfo = authentication.principal as OAuth2UserInfo
        val accessToken = memberService.socialLogin(userInfo).token
        val cookie = Cookie("token", accessToken)
        cookie.path = "/"
        cookie.domain = "사이트 주소.net"
        cookie.maxAge = 5
        cookie.isHttpOnly = false
        cookie.secure = false
        response.addCookie(cookie)
        response.sendRedirect("https://www.사이트주소.net")
    }

    // 이 내용이 주석 처리된 내용
    //    override fun onAuthenticationSuccess(
//        request: HttpServletRequest?,
//        response: HttpServletResponse?,
//        chain: FilterChain?,
//        authentication: Authentication?
//    ) {
//        super.onAuthenticationSuccess(request, response, chain, authentication)
//    }
}