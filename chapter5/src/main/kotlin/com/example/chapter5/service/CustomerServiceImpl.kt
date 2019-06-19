package com.example.chapter5.service

import com.example.chapter5.Customer
import com.example.chapter5.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Service
class CustomerServiceImpl : CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int): Mono<Customer> = customerRepository.findById(id)

    override fun createCustomer(customer: Mono<Customer>): Mono<Customer> = customerRepository.create(customer)

    override fun deleteCustomer(id: Int): Mono<Boolean> = customerRepository.deleteById(id).map { it.deletedCount > 0 }

    override fun searchCustomer(nameFilter: String): Flux<Customer> = customerRepository.findCustomer(nameFilter)

}
