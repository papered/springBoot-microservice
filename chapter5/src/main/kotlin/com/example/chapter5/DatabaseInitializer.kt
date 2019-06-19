package com.example.chapter5

import com.example.chapter5.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component
import reactor.core.publisher.toMono
import javax.annotation.PostConstruct

@Component
class DatabaseInitializer {
}