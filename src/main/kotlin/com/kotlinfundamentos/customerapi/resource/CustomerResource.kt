package com.kotlinfundamentos.customerapi.resource

import com.kotlinfundamentos.customerapi.dto.mapper.toCustomer
import com.kotlinfundamentos.customerapi.dto.mapper.toCustomerResponseDto
import com.kotlinfundamentos.customerapi.dto.mapper.toUpdateCustomer
import com.kotlinfundamentos.customerapi.dto.request.CustomerDto
import com.kotlinfundamentos.customerapi.dto.response.CustomerResponseDto
import com.kotlinfundamentos.customerapi.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/customers")
class CustomerResource (
    private val customerService : CustomerService
) {

    @GetMapping
    fun findAll(@RequestParam("limit") limit: Int, @RequestParam("offset") offset: Int): Page<CustomerResponseDto> {
        val page = PageRequest.of(offset * limit, limit);
        return customerService.findAll(page)
            .map { it.toCustomerResponseDto() };
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody customerDto: CustomerDto) {
        customerService.save(customerDto.toCustomer())
    }


    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable("customerId") customerId: Int, @RequestBody customerDto: CustomerDto) {
        var customer = customerService.findById(customerId)
        customerService.update(customerDto.toUpdateCustomer(customer))
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable("customerId") customerId: Int): CustomerResponseDto {
        return customerService.findById(customerId)
            .toCustomerResponseDto()
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable("customerId") customerId: Int) {
        customerService.deleteById(customerId)
    }

}