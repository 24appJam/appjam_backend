package com.appjam.appjamserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AppjamServerApplication

fun main(args: Array<String>) {
    runApplication<AppjamServerApplication>(*args)
}
