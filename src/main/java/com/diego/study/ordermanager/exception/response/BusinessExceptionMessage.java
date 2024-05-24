package com.diego.study.ordermanager.exception.response;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BusinessExceptionMessage implements Serializable {
    private String errorMessage;
    private Integer status;
    private LocalDateTime errorDateTime;

    public BusinessExceptionMessage(String errorMessage, Integer status, LocalDateTime errorDateTime) {
        this.errorMessage = errorMessage;
        this.status = status;
        this.errorDateTime = errorDateTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getErrorDateTime() {
        return errorDateTime;
    }

    public void setErrorDateTime(LocalDateTime errorDateTime) {
        this.errorDateTime = errorDateTime;
    }
}
