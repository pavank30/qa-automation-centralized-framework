package com.pavan.qe.commons.exceptions;

public class DriverException extends FrameworkException {
    public DriverException(String message) {
        super(message);
    }

    public DriverException(String message, Throwable cause) {
        super(message, cause);
    }
}
