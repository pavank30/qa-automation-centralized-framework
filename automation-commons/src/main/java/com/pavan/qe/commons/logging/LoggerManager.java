package com.pavan.qe.commons.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LoggerManager {


    private LoggerManager() {
        // Private constructor to prevent instantiation
    }

    public static Logger getLogger(Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}
