package com.diego.study.ordermanager.exception.response;

import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BusinessExceptionMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private LocalDateTime errorDateTime;
    String errorMessage;
    private Integer status;
    private String path;

    public BusinessExceptionMessage(LocalDateTime errorDateTime, String errorMessage, Integer status, String path) {
        this.errorDateTime = errorDateTime;
        this.errorMessage = errorMessage;
        this.status = status;
        this.path = path;
    }

    public LocalDateTime getErrorDateTime() {
        return errorDateTime;
    }

    public void setErrorDateTime(LocalDateTime errorDateTime) {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
