package com.hercute.mcrabe.domain.members.repository

import com.hercute.mcrabe.domain.members.entity.Member
import com.hercute.mcrabe.domain.members.entity.Provider
import com.hercute.mcrabe.domain.members.entity.ProviderMap
import org.springframework.data.jpa.repository.JpaRepository

interface ProviderMapRepository : JpaRepository<ProviderMap, Long> {
    fun fineByMemberId(memberId : Long) : ProviderMap

    fun deleteByMemberId(memberId: Long) : Any


//    fun restoreProviderMapByMemberId(@param("memberid") memberId: Long): ProviderMap?
}