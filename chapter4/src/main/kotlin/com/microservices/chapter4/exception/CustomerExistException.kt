package com.microservices.chapter4.exception

class CustomerExistException(override val message: String) : Exception(message)