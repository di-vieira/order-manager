package com.diego.study.ordermanager.exception.response;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class InternalServerErrorMessage implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    private LocalDateTime errorDateTime;
    private Integer status;
    private String exception;
    private String errorMessage;
    private String path;

    public InternalServerErrorMessage(LocalDateTime errorDateTime, Integer status, String exception, String errorMessage, String path) {
        this.errorDateTime = errorDateTime;
        this.status = status;
        this.exception = exception;
        this.errorMessage = errorMessage;
        this.path = path;
    }

    public LocalDateTime getErrorDateTime() {
        return errorDateTime;
    }

    public void setErrorDateTime(LocalDateTime errorDateTime) {
        this.errorDateTime = errorDateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
