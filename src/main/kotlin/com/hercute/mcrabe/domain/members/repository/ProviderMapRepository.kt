package com.hercute.mcrabe.domain.members.repository

import com.hercute.mcrabe.domain.members.entity.Member
import com.hercute.mcrabe.domain.members.entity.Provider
import com.hercute.mcrabe.domain.members.entity.ProviderMap
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface ProviderMapRepository : JpaRepository<ProviderMap, Long> {
    fun findByMemberId(memberId : Long) : ProviderMap

    fun deleteByMemberId(memberId: Long) : Any

//    fun restoreProviderMapByMemberId(@Param("memberid") memberId: Long): ProviderMap?
}