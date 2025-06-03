package com.example.optimization.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> _400Exception(RuntimeException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(e);
    }
}
