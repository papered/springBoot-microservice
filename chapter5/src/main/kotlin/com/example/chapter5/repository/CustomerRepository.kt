package com.example.chapter5.repository

import com.example.chapter5.Customer
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.data.mongodb.core.remove
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import javax.annotation.PostConstruct

@Repository
class CustomerRepository(private val template: ReactiveMongoTemplate) {
    companion object {
        val initialCustomers = listOf(Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservie", Customer.Telephone("+44", "12345678")))
    }

    @PostConstruct
    fun initRepo() = initialCustomers.map(Customer::toMono).map(this::create).map(Mono<Customer>::subscribe)


    fun create(customer: Mono<Customer>) = template.save(customer)

    fun deleteById(id: Int) = template.remove<Customer>(Query(where("_id").isEqualTo(id)))

    fun findById(id: Int) = template.findById<Customer>(id)

    fun findCustomer(nameFilter: String) = template.find<Customer>(
            Query(where("name").regex(".*$nameFilter.*", "i"))
    )
}
