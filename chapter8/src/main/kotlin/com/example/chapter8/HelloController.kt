package com.example.chapter8

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

@RestController
class HelloController {
    private val id = UUID.randomUUID().toString()

    companion object {
        val total = AtomicInteger()
    }

    @GetMapping("/hello")
    fun hello() = "hello im $id and i have been called ${total.incrementAndGet()} time(s)"
}