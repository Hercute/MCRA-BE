package com.hercute.mcrabe.domain.cart.repository

import com.hercute.mcrabe.domain.cart.model.Cart
import com.hercute.mcrabe.domain.cart.model.QCart
import com.hercute.mcrabe.global.infra.querydsl.QueryDslSupport
import com.querydsl.core.BooleanBuilder
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.sql.Timestamp

class CartRepositoryImpl: QueryDslSupport(), CustomCartRepository {

    private val cart = QCart.cart

    override fun findItemByPurchaseStatus(pageable: Pageable, purchaseDate: Timestamp?): Page<Cart> {

        val totalCount = queryFactory.select(cart.count()).from(cart).fetchOne() ?: 0L
        val builder = BooleanBuilder()

        if (purchaseDate != null) {
            builder.and(cart.purchaseDate.eq(purchaseDate))
        } else {
            builder.and(cart.purchaseDate.isNull())
        }
        val query = queryFactory.selectFrom(cart)
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .where(builder)

        val contents =query.fetch()
        return PageImpl(contents, pageable, totalCount)
    }
}