package com.hercute.mcrabe.domain.members.entity

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

class ProviderMap(
    // 여기서 var 값을 private로 변경할 수도 있는데, 이 경우 어떤 영향을 줄지 모르겠어서 var로 기입
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
            Provider.KAKAO -> isKakaoMember = true
            Provider.NAVER -> isNaverMember = true
            Provider.GOOGLE -> isGoogleMember = true
        }
    }
}