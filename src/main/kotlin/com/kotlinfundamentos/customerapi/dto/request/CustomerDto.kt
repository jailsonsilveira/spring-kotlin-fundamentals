package com.kotlinfundamentos.customerapi.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

data class CustomerDto (

    @field:NotEmpty(message = "Name should be informed")
    @field:Length(max = 45)
    var name: String,
    var email: String
)