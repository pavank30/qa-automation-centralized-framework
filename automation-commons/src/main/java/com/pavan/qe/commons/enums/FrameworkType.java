
package com.pavan.qe.commons.enums;

public enum FrameworkType {

    SELENIUM("selenium"),
    APPIUM("appium"),
    API("api"),
    PLAYWRIGHT("playwright");

    private final String value;

    // Enum constructor
    FrameworkType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static FrameworkType from(String framework) {

        if (framework == null || framework.isBlank()) {
            throw new IllegalArgumentException(
                    "Framework type cannot be null or empty."
            );
        }

        for (FrameworkType frameworkType : FrameworkType.values()) {
            if (frameworkType.getValue().equalsIgnoreCase(framework.trim())) {
                return frameworkType;
            }
        }

        throw new IllegalArgumentException(
                "Unsupported framework type: " + framework
        );
    }
}
