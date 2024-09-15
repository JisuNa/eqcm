package com.eqcm.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EqcmApplication

fun main(args: Array<String>) {
    runApplication<EqcmApplication>(*args)
}
