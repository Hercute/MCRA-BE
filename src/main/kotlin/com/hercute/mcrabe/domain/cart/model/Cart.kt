package com.hercute.mcrabe.domain.cart.model

import com.hercute.mcrabe.global.common.BaseEntity
import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "carts")
class Cart (

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    val category: Category,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    val member: Member,

    val name: String,

    val memo: String,

    val purchase: Boolean = false,

    val purchaseDate: Timestamp? = null

): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}