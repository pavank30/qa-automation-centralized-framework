package com.pavan.qe.commons.exceptions;

public class ValidationException extends FrameworkException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
