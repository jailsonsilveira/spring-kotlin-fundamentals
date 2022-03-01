package com.kotlinfundamentos.customerapi.service

import com.kotlinfundamentos.customerapi.model.Customer
import com.kotlinfundamentos.customerapi.repository.CustomerRepository
import org.springframework.stereotype.Service

interface CustomerService: GenericCrudService<Customer, Int> {

    val customerRepository: CustomerRepository;
}