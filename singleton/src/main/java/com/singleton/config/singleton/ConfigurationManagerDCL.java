package com.singleton.config.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManagerDCL {

    private static volatile ConfigurationManagerDCL instance;
    private final Properties properties = new Properties();
    private ConfigurationManagerDCL() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration", e);
        }
    }

    public static ConfigurationManagerDCL getInstance() {

        if (instance == null) {
            synchronized (ConfigurationManagerDCL.class) {
                if (instance == null) {
                    instance = new ConfigurationManagerDCL();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
