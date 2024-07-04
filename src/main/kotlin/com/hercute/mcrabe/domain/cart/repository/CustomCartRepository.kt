package com.hercute.mcrabe.domain.cart.repository

import com.hercute.mcrabe.domain.cart.model.Cart
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.sql.Timestamp

interface CustomCartRepository {

    fun findItemByPurchaseStatus(pageable: Pageable, purchaseDate: Timestamp?): Page<Cart>
}