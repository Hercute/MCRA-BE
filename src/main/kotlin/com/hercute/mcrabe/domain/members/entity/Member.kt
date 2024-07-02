package com.hercute.mcrabe.domain.members.entity

import jakarta.persistence.*

class Member(
    @Column(name = "email", unique = true)
    var email: String,

    @Column(name = "password")
    var password : String? = null,

    @Column(name = "nickname")
    var nickname : String,

    @Column(name = "introduce")
    var introduce: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    val role : MemberRole,
)
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
enum class MemberRole {
    ADMIN, MEMBER, NONMEMBER
}

enum class Provider{
    GOOGLE, KAKAO, NAVER
}