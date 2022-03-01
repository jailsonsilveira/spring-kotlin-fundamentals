package com.kotlinfundamentos.customerapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Adress (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,
        var street: String,
        var city: String,
        var postCode: String
)
