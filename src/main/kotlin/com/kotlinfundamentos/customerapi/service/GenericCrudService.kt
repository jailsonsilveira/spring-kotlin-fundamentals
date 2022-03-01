package com.kotlinfundamentos.customerapi.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface GenericCrudService<T, ID> {

    fun findAll(pageable: Pageable): Page<T>

    fun save(entity: T): T

    fun update(entity: T): T

    fun findById(id: ID): T

    fun deleteById(id: ID)

}