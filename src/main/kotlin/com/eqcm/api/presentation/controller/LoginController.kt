package com.eqcm.api.presentation.controller

import com.eqcm.api.application.service.LoginService
import com.eqcm.api.domain.vo.AuthTokenVo
import com.eqcm.api.presentation.common.response.SingleResponse
import com.eqcm.api.presentation.controller.request.EmailLoginRequest
import com.eqcm.api.presentation.controller.request.NaverLoginRequest
import com.eqcm.api.presentation.controller.response.NaverLoginInfoResponse
import jakarta.servlet.http.HttpServletResponse
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
    fun emailLogin(@RequestBody @Validated req: EmailLoginRequest): SingleResponse<AuthTokenVo> {
        return SingleResponse(loginService.emailLogin(req.email, req.password))
    }

    @GetMapping("/naver/callback", name = "네이버 로그인 콜백")
    fun callBackNaverLogin(req: NaverLoginRequest, response: HttpServletResponse): NaverLoginInfoResponse {
        return NaverLoginInfoResponse(req.code, req.state)
    }

    @GetMapping("/naver/token", name = "네이버 로그인 토큰")
    fun getNaverLoginToken(req: NaverLoginRequest): SingleResponse<AuthTokenVo> {
        return SingleResponse(loginService.getNaverLoginToken(req.code, req.state))
    }
}
