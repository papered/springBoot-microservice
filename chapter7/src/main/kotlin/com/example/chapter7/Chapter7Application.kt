package com.example.chapter7

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Chapter7Application

@RestController
class GreetingController() {
    @GetMapping("/hello")
    fun hello() = "hello"
}

fun main(args: Array<String>) {
    runApplication<Chapter7Application>(*args)
}
