package com.kotlinfundamentos.customerapi.exception

import com.kotlinfundamentos.customerapi.dto.response.ErrorResponseDto
import com.kotlinfundamentos.customerapi.dto.response.FieldErrorResponseDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.function.Consumer


@ControllerAdvice
class ApiException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(
        ex: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponseDto> {
        val errors = ErrorResponseDto(
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            "ValidationFailed",
            ex.bindingResult.fieldErrors.map { FieldErrorResponseDto(it.defaultMessage ?: "invalid value", it.field) }
        )

        return return ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }
}