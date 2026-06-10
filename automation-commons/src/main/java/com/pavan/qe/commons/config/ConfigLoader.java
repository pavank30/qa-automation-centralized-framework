package com.pavan.qe.commons.config;

import com.pavan.qe.commons.exceptions.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public final class ConfigLoader {

    private static final Properties properties = new Properties();
    private static final Logger log = LoggerFactory.getLogger(ConfigLoader.class);

    static {

        String env = System.getProperty("env", "qa");
        String fileName = "config/" + env + ".properties";

        log.info("Loading configuration from file: {}", fileName);

        try {
            InputStream inputStream = ConfigLoader.class.getClassLoader().getResourceAsStream(fileName);

            if (inputStream == null) {
                log.error("Configuration file not found: {}", fileName);
                throw new ConfigurationException("Config file not found: " + fileName);
            }
            properties.load(inputStream);
            log.info("Configuration loaded successfully from file: {}", fileName);

        } catch (IOException e) {
            log.error("Error loading configuration file: {}", fileName, e);
            throw new ConfigurationException("Failed to load configuration file: " + fileName, e);
        }
    }

    private ConfigLoader() {
        // Private constructor to prevent instantiation
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String get(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }


}
