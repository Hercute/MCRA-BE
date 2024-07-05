package com.hercute.mcrabe.domain.fridge.model

import com.hercute.mcrabe.domain.categories.model.Categories
import com.hercute.mcrabe.domain.members.entity.Member
import com.hercute.mcrabe.global.common.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction
import java.sql.Timestamp

@Entity
@SQLDelete(sql = "UPDATE fridges SET is_deleted = true WHERE id = ?") // DELETE 쿼리 날아올 시 대신 실행
@SQLRestriction("is_deleted = false")
@Table(name = "fridges")
class Fridge(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    var category: Categories,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,

    var name: String,

    var expirationDate: Timestamp? = null,

    var memo: String,

    var storage: Storage = Storage.COLD

): BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}