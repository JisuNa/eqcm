package com.eqcm.api.infrastructure.persistence.entity

import com.eqcm.api.domain.declaration.TermsType
import com.eqcm.api.domain.declaration.Yn
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import org.springframework.data.annotation.CreatedDate

@Entity
class MemberAgreement(
    @Id
    val memberId: Long,
    val termsType: TermsType,
    val agreeYn: Yn
) {
    @CreatedDate
    val createdDtm: LocalDateTime = LocalDateTime.now()
    var updatedDtm: LocalDateTime = LocalDateTime.now()
}
