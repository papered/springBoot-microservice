package com.example.chapter6discoveryserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class Chapter6DiscoveryserverApplication

fun main(args: Array<String>) {
    runApplication<Chapter6DiscoveryserverApplication>(*args)
}
