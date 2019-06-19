package com.example.chapter6

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {
    @Value("\${microservice.example.greetings}")
    lateinit var greetings: String

    @GetMapping("/greetings")
    fun greetings() = greetings
}