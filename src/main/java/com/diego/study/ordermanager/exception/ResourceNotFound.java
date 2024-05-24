package com.diego.study.ordermanager.exception;

public class ResourceNotFound extends BusinessException{

    public ResourceNotFound(String message) {
        super(message);
    }

    public ResourceNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
