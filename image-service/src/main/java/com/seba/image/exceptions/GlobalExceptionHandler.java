package com.seba.image.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final String TAG = "CONTROLLER_ADVICE - ";

    @ExceptionHandler(ResourceNotFindException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionBody handleResourceNotFound(ResourceNotFindException ex) {
        log.error(TAG + ex.getMessage());
        return new ExceptionBody(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
