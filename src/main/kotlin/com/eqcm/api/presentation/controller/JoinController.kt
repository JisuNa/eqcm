package com.eqcm.api.presentation.controller

import com.eqcm.api.application.service.JoinService
import com.eqcm.api.presentation.common.response.NoDataResponse
import com.eqcm.api.presentation.controller.request.EmailJoinRequest
import com.eqcm.api.presentation.controller.request.SocialJoinRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/join")
class JoinController(private val joinService: JoinService) {
    @PostMapping("/email", name = "이메일 회원가입")
    fun emailJoin(@RequestBody @Validated req: EmailJoinRequest): NoDataResponse {
        joinService.emailJoin(req)
        return NoDataResponse()
    }

    @PostMapping("/social", name = "소셜 회원가입")
    fun socialJoin(@RequestBody @Validated req: SocialJoinRequest): NoDataResponse {
        joinService.socialJoin(req)
        return NoDataResponse()
    }
}
