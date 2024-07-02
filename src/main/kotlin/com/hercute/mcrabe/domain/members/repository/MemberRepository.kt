package com.hercute.mcrabe.domain.members.repository

import com.hercute.mcrabe.domain.members.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param



interface MemberRepository : JpaRepository<Member, Long> {
    fun restoreMemberByEmail(@Param("email") email : String) : Member?

    fun findByEmail(email: String) : Member?
}