package com.eqcm.api.presentation.controller

import com.eqcm.api.presentation.common.response.NoDataResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping(name = "메인페이지")
    fun getMain() = NoDataResponse()
}
