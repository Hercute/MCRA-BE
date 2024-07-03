package com.hercute.mcrabe.domain.members.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ProviderMap(
    var isCommonMember: Boolean = false,
    var isKakaoMember: Boolean = false,
    var isNaverMember: Boolean = false,
    var isGoogleMember: Boolean = false,
    val memberId: Long,
    var isDeleted: Boolean = false,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    fun registerSocialInfo(socialInfo: Provider) {
        when (socialInfo) {
            Provider.COMMON -> isCommonMember = true
            Provider.KAKAO -> isKakaoMember = true
            Provider.NAVER -> isNaverMember = true
            Provider.GOOGLE -> isGoogleMember = true
        }
    }
}