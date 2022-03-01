package com.kotlinfundamentos.customerapi.service.impl

import com.kotlinfundamentos.customerapi.model.Customer
import com.kotlinfundamentos.customerapi.repository.CustomerRepository
import com.kotlinfundamentos.customerapi.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerServiceImpl(override val customerRepository: CustomerRepository) : CustomerService {

    override fun findAll(pageable: Pageable): Page<Customer> = customerRepository.findAll(pageable)


    override fun save(entity: Customer) = customerRepository.save(entity)

    override fun update(entity: Customer): Customer {
       return customerRepository.save(entity)
    }


    override fun findById(id: Int): Customer {
        return customerRepository.findById(id)
            .orElseThrow { RuntimeException("Customer not found") }
    }

    override fun deleteById(id: Int) =  customerRepository.deleteById(id)
}