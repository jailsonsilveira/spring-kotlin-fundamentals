package com.kotlinfundamentos.customerapi.repository

import com.kotlinfundamentos.customerapi.model.Customer
import org.springframework.data.repository.PagingAndSortingRepository

interface CustomerRepository : PagingAndSortingRepository<Customer, Int> {

}
