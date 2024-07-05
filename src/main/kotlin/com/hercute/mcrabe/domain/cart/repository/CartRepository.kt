package com.hercute.mcrabe.domain.cart.repository

import com.hercute.mcrabe.domain.cart.model.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface CartRepository: JpaRepository<Cart, Long>, CustomCartRepository {
    fun findAllByMemberId(memberId : Long) : List<Cart?>
}