package com.eqcm.api.common.declaration

import jakarta.persistence.Converter

enum class SocialProviderType(
    override val dbCode: String,
    override val title: String
) : BaseEnum {
    NAVER("NAVER", "네이버"),
    KAKAO("KAKAO", "카카오"),
    GOOGLE("GOOGLE", "구글"),
}

@Converter(autoApply = true)
class SocialProviderTypeConverter : AbstractBaseEnumConverter<SocialProviderType>(SocialProviderType::class.java)
