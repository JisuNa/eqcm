package com.eqcm.api.domain.declaration

enum class SocialProviderType(
    override val dbCode: String,
    override val title: String
) : BaseEnum {
    NAVER("NAVER", "네이버"),
    KAKAO("KAKAO", "카카오"),
    GOOGLE("GOOGLE", "구글"),
}
