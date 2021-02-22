package com.demo.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerAdvice {
	@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NoSuchElementException.class)
    public void handleNotFoundConflict() {
    }
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(Exception.class)
    public void handleOtherConflict() {
    }
}
