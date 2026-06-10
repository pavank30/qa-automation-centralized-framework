package com.pavan.qe.commons.context;

import com.pavan.qe.commons.exceptions.FrameworkException;

import java.time.Instant;
import java.util.UUID;

public final class FrameworkContext {

    private static final ThreadLocal<ExecutionContext> CONTEXT = new ThreadLocal<>();

    private FrameworkContext() {
        // Prevent instantiation
    }

    /**
     * Initializes execution context for the current thread.
     *
     * @param browser Browser name (chrome, firefox, edge...)
     * @param platform Platform name (web, android, ios...)
     */
    public static void initialize(String browser, String platform) {

        ExecutionContext context = new ExecutionContext();

        context.setExecutionId(UUID.randomUUID().toString());
        context.setStartTime(Instant.now());

        // Source of truth for environment
        context.setEnvironment(System.getProperty("env", "qa"));

        context.setBrowser(browser);
        context.setPlatform(platform);

        CONTEXT.set(context);
    }

    /**
     * Returns current thread's ExecutionContext.
     */
    public static ExecutionContext get() {

        ExecutionContext context = CONTEXT.get();

        if (context == null) {
            throw new FrameworkException(
                    "FrameworkContext is not initialized. " +
                            "Call FrameworkContext.initialize() before using it."
            );
        }

        return context;
    }

    /**
     * Clears ThreadLocal to prevent memory leaks.
     * Must be called after every test execution.
     */
    public static void clear() {
        CONTEXT.remove();
    }

}