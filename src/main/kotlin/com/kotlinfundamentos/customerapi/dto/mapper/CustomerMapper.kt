package com.kotlinfundamentos.customerapi.dto.mapper

import com.kotlinfundamentos.customerapi.dto.request.CustomerDto
import com.kotlinfundamentos.customerapi.dto.response.CustomerResponseDto
import com.kotlinfundamentos.customerapi.model.Adress
import com.kotlinfundamentos.customerapi.model.Customer

fun CustomerDto.toCustomer() = Customer(
    name = this.name,
    email = this.email,
    adress =  Adress(
        street = "123",
        city = "123",
        postCode = "123"
    )
)

fun CustomerDto.toUpdateCustomer(customer: Customer) = Customer(
    id = customer.id,
    name = this.name ?: customer.name,
    email = this.email ?: customer.email,
    adress =  Adress(
        street = "123" ?: customer.adress?.street,
        city = "123" ?: customer.adress?.city,
        postCode = "123" ?: customer.adress?.street
    )
)

fun Customer.toCustomerResponseDto() = CustomerResponseDto(name = this.name, email = this.email, id = this.id ?: 0)
