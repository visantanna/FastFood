package com.fiap.fastfood.fastfood.adapter.input.rest.config

import com.fiap.fastfood.fastfood.application.domain.exception.BussinessLogicException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class BussinessExceptionResolver {
    @ExceptionHandler(BussinessLogicException::class)
    fun handleBussinessException(exception: BussinessLogicException): ResponseEntity<String>{
        return ResponseEntity
            .status(exception.status)
            .body(exception.mensagem)
    }
}
