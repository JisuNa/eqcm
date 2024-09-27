package com.eqcm.api.domain.declaration

enum class TermsType(
    override val dbCode: String,
    override val title: String
) : BaseEnum {
    SERVICE("SERVICE", "서비스 이용약관"),
    PRIVACY("PRIVACY", "개인정보 처리방침"),
    MARKETING("MARKETING", "마케팅 정보 수신 동의"),
    ADVERTISING("ADVERTISING", "광고성 정보 수신 동의")
}
