package com.eqcm.api.presentation.controller

import com.eqcm.api.application.service.LoginService
import com.eqcm.api.domain.vo.AuthTokenDto
import com.eqcm.api.presentation.common.response.SingleResponse
import com.eqcm.api.presentation.controller.request.EmailLoginRequest
import com.eqcm.api.presentation.controller.request.NaverLoginRequest
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class LoginController(private val loginService: LoginService) {
    @PostMapping("/email", name = "이메일 로그인")
    fun emailLogin(@RequestBody @Validated req: EmailLoginRequest): SingleResponse<AuthTokenDto> {
        return SingleResponse(loginService.emailLogin(req.email, req.password))
    }

    @GetMapping("/naver", name = "네이버 로그인")
    fun naverLogin(req: NaverLoginRequest): SingleResponse<AuthTokenDto> {
        return SingleResponse(loginService.naverLogin(req.code, req.state))
    }
}
