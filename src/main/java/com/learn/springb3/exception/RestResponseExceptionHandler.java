package com.learn.springb3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestResponseExceptionHandler {

    @ExceptionHandler({ Exception.class, BussinesException.class, NotExistsException.class })
    public ResponseEntity<Object> handleException(
            Exception ex, WebRequest request) throws Exception {

        if(ex instanceof BussinesException){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }else if(ex instanceof NotExistsException){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }else {
            ex.printStackTrace();
            return new ResponseEntity<>("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        } 

    }
}
