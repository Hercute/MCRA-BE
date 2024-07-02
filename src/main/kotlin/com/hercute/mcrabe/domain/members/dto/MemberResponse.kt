package com.hercute.mcrabe.domain.members.dto

import com.hercute.mcrabe.domain.members.entity.Member
import com.hercute.mcrabe.domain.members.entity.MemberRole

data class MemberResponse(
    val id : Long,
    val email : String,
    val nickname : String,
    val role : MemberRole,
    val introduce : String,
) {
    companion object {
        fun from(member: Member): MemberResponse {
            return MemberResponse(
                id = member.id!!,
                email = member.email,
                nickname = member.nickname,
                role = member.role,
                introduce = member.introduce
            )
        }
    }
}