package com.example.apiRestBetlab.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> customizeValidationErrors(MethodArgumentNotValidException error,
                                                                   HttpServletRequest request){
        ValidationError validationError = new ValidationError(HttpStatus.NOT_FOUND.value(),"Validation Error",System.currentTimeMillis());

        for(FieldError fieldErrorObject : error.getBindingResult().getFieldErrors()){
            validationError.addError(fieldErrorObject.getField(), fieldErrorObject.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationError);
    }
}