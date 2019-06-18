package com.microservices.chapter4

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import reactor.core.publisher.switchIfEmpty
import reactor.core.publisher.toMono

@Component
class CustomerHandler(val customerService: CustomerService) {

    fun get(serverRequest: ServerRequest): Mono<ServerResponse> =
            customerService.getCustomer(serverRequest.pathVariable("id").toInt())
                    .flatMap { ok().body(fromObject(it)) }
                    .switchIfEmpty { notFound().build() }

    fun create(serverRequest: ServerRequest): Mono<ServerResponse> =
            customerService.createCustomer(serverRequest.bodyToMono())
                    .flatMap { status(HttpStatus.CREATED).body(fromObject(it)) }

    fun search(serverRequest: ServerRequest) =
            ok().body(customerService.searchCustomers(serverRequest.queryParam("nameFilter").orElse("")), Customer::class.java)

}