package com.hercute.mcrabe.domain.fridge.repository

import com.hercute.mcrabe.domain.fridge.model.Fridge
import org.springframework.data.jpa.repository.JpaRepository

interface FridgeRepository: JpaRepository<Fridge, Long> {
    fun findByMemberId(memberId: Long): List<Fridge>
}