package com.hercute.mcrabe.domain.members.entity

import jakarta.persistence.*

@Table
@Entity
class Member(
    @Column(name = "email", unique = true)
    var email: String,

    // 원래 password도 따로 받아서 저장했었나요?
    @Column(name = "password")
    var password : String? = null,

    @Column(name = "nickname")
    var nickname : String,

    @Column(name = "introduce")
    var introduce: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    val role : MemberRole,

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
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var fridges : MutableList<fridges> = mutableListOf()

// chatroom(채팅방) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var chatrooms : MutableList<chatrooms> = mutableListOf()

// chatmessages(채팅메시지) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var chatmessages : MutableList<chatmessages> = mutableListOf()

// likes(좋아요) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var likes : MutableList<likes> = mutableListOf()

// recipes(레시피) 와의 1대 다 관계 설정
//    @OneToMany(
//        mappedBy = "category",
//        fetch = FetchType.LAZY,
//        cascade = [CascadeType.ALL],
//        orphanRemoval = true
//    )
//    var recipes : MutableList<recipes> = mutableListOf()
)
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}
enum class MemberRole {
    ADMIN, MEMBER, NONMEMBER
}

enum class Provider{
    COMMON, GOOGLE, KAKAO, NAVER
}