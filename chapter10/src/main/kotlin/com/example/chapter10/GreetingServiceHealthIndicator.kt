package com.example.chapter10

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component

@Component
class GreetingServiceHealthIndicator : AbstractHealthIndicator() {

    @Autowired
    lateinit var greetingService: GreetingService

    override fun doHealthCheck(builder: Health.Builder) {
        val lastMessage = try {
            val message = greetingService.greeting()
            builder.up()
            message
        } catch (e: Exception) {
            builder.down()
            "ERROR $e"
        }
        builder.withDetail("lastMessage", lastMessage)
    }

}