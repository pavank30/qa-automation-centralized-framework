package com.pavan.qe.commons.exceptions;

public class ApiException extends FrameworkException {
    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
