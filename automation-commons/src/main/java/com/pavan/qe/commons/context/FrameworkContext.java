
package com.pavan.qe.commons.context;

import com.pavan.qe.commons.enums.FrameworkType;
import com.pavan.qe.commons.exceptions.FrameworkException;

import java.time.Instant;
import java.util.UUID;

public final class FrameworkContext {

    private static final ThreadLocal<ExecutionContext> CONTEXT =
            new ThreadLocal<>();

    private FrameworkContext() {
        // Prevent instantiation
    }

    /**
     * Initializes execution context for the current thread.
     *
     * @param framework  Automation framework (selenium, appium, api, playwright)
     * @param environment Execution environment (qa, stage, prod)
     * @param platform   Execution platform (web, android, ios, api)
     */
    public static void initialize(
            FrameworkType framework,
            String environment,
            String platform) {

        if (framework == null) {
            throw new FrameworkException(
                    "Framework type cannot be null."
            );
        }

        if (environment == null || environment.isBlank()) {
            throw new FrameworkException(
                    "Environment cannot be null or empty."
            );
        }

        if (platform == null || platform.isBlank()) {
            throw new FrameworkException(
                    "Platform cannot be null or empty."
            );
        }

        ExecutionContext context = new ExecutionContext();

        context.setExecutionId(UUID.randomUUID().toString());
        context.setFramework(framework.getValue());
        context.setEnvironment(environment.trim());
        context.setPlatform(platform.trim());
        context.setStartTime(Instant.now());

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
