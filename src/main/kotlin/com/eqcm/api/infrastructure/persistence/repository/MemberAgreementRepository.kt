package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.MemberAgreement
import org.springframework.data.jpa.repository.JpaRepository

interface MemberAgreementRepository: JpaRepository<MemberAgreement, Long>