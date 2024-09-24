package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.MemberSocial
import org.springframework.data.jpa.repository.JpaRepository

interface MemberSocialRepository: JpaRepository<MemberSocial, Long>