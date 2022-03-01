package com.kotlinfundamentos.customerapi.dto.response

data class ErrorResponseDto(
    var status: Int,
    var message: String,
    var errors: List<FieldErrorResponseDto>?
)