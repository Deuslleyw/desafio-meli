package com.deusleydev.api_desafio_meli.exeptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<StandardError> produtoNotFound(
            ProdutoNotFoundException er, HttpServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
                er.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
