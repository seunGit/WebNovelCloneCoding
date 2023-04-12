package com.example.webnovelclonecoding.common.exception;

import com.example.webnovelclonecoding.common.dto.ResponseDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity IllegalArgumentExceptionHandler(Exception e) {
        logger.error("", e);
        ResponseDto response = new ResponseDto("fail", e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity NoSuchElementExceptionHandler(Exception e) {
        logger.error("", e);
        ResponseDto response = new ResponseDto("fail", e.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
