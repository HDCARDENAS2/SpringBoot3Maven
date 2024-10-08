package com.learn.springb3.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.springb3.exception.BussinesException;
import com.learn.springb3.exception.NotExistsException;

@ControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(value= NotExistsException.class)
    public ResponseEntity<String> handleNotExistsException(NotExistsException businessException) {
        return new ResponseEntity<>(businessException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= BussinesException.class)
    public ResponseEntity<String> handleBusinessException(BussinesException bussinesException) {
        return new ResponseEntity<>(bussinesException.getMessage(), HttpStatus.BAD_REQUEST);
    }	


    
}
