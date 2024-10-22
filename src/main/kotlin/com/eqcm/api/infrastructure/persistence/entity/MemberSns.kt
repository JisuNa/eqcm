package com.eqcm.api.infrastructure.persistence.entity

import com.eqcm.api.domain.declaration.SnsType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class MemberSns(
    @Id
    val memberId: Long,
    val snsId: String,
    val snsType: SnsType,
    val snsProfile: String,
    val snsConnectDtm: LocalDateTime
)
