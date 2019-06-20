package com.example.chapter10

import org.springframework.stereotype.Service
import java.util.*

@Service
class GreetingServiceImpl : GreetingService {
    companion object {
        val greetingsMessages = arrayOf("ㅎㅇ", "ㅂㅇ", "ㅎㅇ~~", "ㅎㅇㅎㅇ")
    }

    override fun greeting() = greetingsMessages[Random().nextInt(4) + 1]
}