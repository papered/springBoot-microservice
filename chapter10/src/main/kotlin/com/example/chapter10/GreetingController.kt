package com.example.chapter10

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    @Autowired
    lateinit var greetingService: GreetingService

    @GetMapping("/hello")
    fun message() = greetingService.greeting()

}