package com.example.chapter5

import org.springframework.data.mongodb.core.mapping.Document

@Document("Customers")
data class Customer(var id: Int = 0, var name: String = "", var telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}