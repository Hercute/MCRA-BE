package com.hercute.mcrabe.domain.members.repository

import com.hercute.mcrabe.domain.members.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository

interface MemberRepository : JpaRepository<Member, Long> {
    @Query(value = "select * from members where email = :email limit 1", nativeQuery = true)
    fun restoreMemberByEmail(@Param("email") email : String) : Member?

    fun findByEmail(email: String) : Member?
}