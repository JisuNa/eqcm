package com.eqcm.api.infrastructure.persistence.entity

import com.eqcm.api.common.declaration.SocialProviderType
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class MemberSocial(
    @Id
    val memberId: Long,
    val providerType: SocialProviderType,
    val socialId: String,
)
