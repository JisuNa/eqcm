package com.eqcm.api.domain.declaration

interface BaseEnum {
    // 데이터베이스에 저장되는 값
    val dbCode: String

    // 일반적으로 읽을 수 있는 값
    val title: String

    // enum 클래스의 이름, 클라이언트에게 입력 받는 값
    val name: String
}