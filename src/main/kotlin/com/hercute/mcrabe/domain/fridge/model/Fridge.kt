package com.hercute.mcrabe.domain.fridge.model

import com.hercute.mcrabe.global.common.BaseEntity
import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "fridges")
class Fridge(

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    val category: Category,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    val member: Member,

    val name: String,

    val expirationDate: Timestamp,

    val memo: String,

    val storage: Storage

): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}