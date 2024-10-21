package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.infrastructure.persistence.entity.MemberSns
import org.springframework.data.jpa.repository.JpaRepository

interface MemberSocialRepository : JpaRepository<MemberSns, Long>
