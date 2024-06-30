package com.diego.study.ordermanager.exception.handler;

import com.diego.study.ordermanager.exception.BusinessException;
import com.diego.study.ordermanager.exception.response.BusinessExceptionMessage;
import com.diego.study.ordermanager.exception.response.InternalServerErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import java.time.LocalDateTime;

@ControllerAdvice
public class ServerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<InternalServerErrorMessage> internalServerError (Exception exception, HttpServletRequest request) {
        InternalServerErrorMessage responseErrorMessage = new InternalServerErrorMessage(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getClass().getName(), exception.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseErrorMessage);
    }
}
