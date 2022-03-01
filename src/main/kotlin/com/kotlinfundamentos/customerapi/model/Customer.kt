package com.kotlinfundamentos.customerapi.model

import javax.persistence.*

@Entity
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    var adress: Adress

)