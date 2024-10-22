package com.eqcm.api.presentation.controller.request

data class NaverLoginRequest(
    val code: String,
    val state: String
)
