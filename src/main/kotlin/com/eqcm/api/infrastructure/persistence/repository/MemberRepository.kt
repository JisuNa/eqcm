package com.eqcm.api.infrastructure.persistence.repository

import com.eqcm.api.domain.value.Email
import com.eqcm.api.infrastructure.persistence.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
    fun findByEmail(email: Email): Member?
}
