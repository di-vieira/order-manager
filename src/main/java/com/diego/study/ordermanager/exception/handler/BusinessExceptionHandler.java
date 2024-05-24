package com.diego.study.ordermanager.exception.handler;

import com.diego.study.ordermanager.exception.BusinessException;
import com.diego.study.ordermanager.exception.ResourceNotFound;
import com.diego.study.ordermanager.exception.response.BusinessExceptionMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<BusinessExceptionMessage> resourceNotFound(BusinessException exception, HttpServletRequest request){
        BusinessExceptionMessage responseError = new BusinessExceptionMessage(exception.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<BusinessExceptionMessage> businessException(BusinessException exception, HttpServletRequest request){
        BusinessExceptionMessage responseError = new BusinessExceptionMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseError);
    }
}
