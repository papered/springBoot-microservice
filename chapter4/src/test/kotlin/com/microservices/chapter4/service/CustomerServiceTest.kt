package com.microservices.chapter4.service

import org.junit.Assert
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CustomerServiceTest {

    @Autowired
    lateinit var customerService: CustomerService

    @Test
    fun getCustomer() {
        val customer = customerService.getCustomer(1)
        Assert.assertNotNull(customer)
    }
}
