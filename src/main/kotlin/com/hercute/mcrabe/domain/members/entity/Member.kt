package com.hercute.mcrabe.domain.members.entity

import com.hercute.mcrabe.global.common.BaseEntity
import com.hercute.mcrabe.global.error.exception.ModelNotFoundException
import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction

@Table
@Entity
@SQLDelete(sql = "UPDATE members SET is_deleted = true WHERE id = ?")
@SQLRestriction("is_deleted = false")

class Member(
    @Column(name = "email", unique = true)
    var email: String,

    @Column(name = "password")
    var password : String? = null,

    @Column(name = "nickname")
    var nickname : String,

    @Column(name = "introduce")
    var introduce: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    val role : MemberRole,
    @Column(name = "is_Blocked")
    var isBlocked: Boolean = false

// cart(장보기 목록) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var carts : MutableList<Cart> = mutableListOf()

// fridges(냉장고) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "fridges",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var fridges : MutableList<fridges> = mutableListOf()

// chatroom(채팅방) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "chatroom",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var chatrooms : MutableList<chatrooms> = mutableListOf()

// chatmessages(채팅메시지) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "chatmessages",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var chatmessages : MutableList<chatmessages> = mutableListOf()

// likes(좋아요) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "likes",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var likes : MutableList<likes> = mutableListOf()

// recipes(레시피) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "recipes",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var recipes : MutableList<recipes> = mutableListOf()
)
    :BaseEntity()
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun updateProfile(nickname: String, introduce: String) {
        this.nickname = nickname
        this.introduce = introduce
    }
}
enum class MemberRole {
    ADMIN, MEMBER, NONMEMBER
}

enum class Provider{
    COMMON, GOOGLE, KAKAO, NAVER
}

