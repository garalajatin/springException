package com.example.dockerdemo.advice;

import com.example.dockerdemo.exception.CustomException;
import com.example.dockerdemo.models.ErrorDTO;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@ControllerAdvice
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class ExceptionAdvice {

    @ExceptionHandler({CustomException.class, ArithmeticException.class, IllegalStateException.class, PropertyValueException.class})
    public ResponseEntity<?> handleException(Exception ex){
        if (ex instanceof  CustomException){
            return new ResponseEntity<>(new ErrorDTO(((CustomException) ex).getErrorCode(),((CustomException) ex).getErrorMessage(),null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ErrorDTO("400",ex.getLocalizedMessage(),null), HttpStatus.BAD_REQUEST);
    }
}
