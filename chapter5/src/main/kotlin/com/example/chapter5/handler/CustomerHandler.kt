package com.example.chapter5.handler

import com.example.chapter5.Customer
import com.example.chapter5.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.switchIfEmpty
import java.net.URI

@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(serverRequest: ServerRequest) =
            customerService.getCustomer(serverRequest.pathVariable("id").toInt())
                    .flatMap { ok().body(fromObject(it)) }
                    .switchIfEmpty { status(HttpStatus.NOT_FOUND).build() }

    fun create(serverRequest: ServerRequest) =
            customerService.createCustomer(serverRequest.bodyToMono())
                    .flatMap { created(URI.create("/customer/${it.id}")).build() }

    fun delete(serverRequest: ServerRequest) =
            customerService.deleteCustomer(serverRequest.pathVariable("id").toInt())
                    .flatMap {
                        if (it) ok().build()
                        else notFound().build()
                    }

    fun search(serverRequest: ServerRequest) =
            ok().body(customerService.searchCustomer(serverRequest.queryParam("nameFilter").orElse("")), Customer::class.java)
}