package com.singleton.config.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManagerHolder {
    private final Properties properties = new Properties();
    private ConfigurationManagerHolder() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties file not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Error loading configuration", e);
        }
    }
    private static class Holder {
        private static final ConfigurationManagerHolder INSTANCE = new ConfigurationManagerHolder();
    }
    public static ConfigurationManagerHolder getInstance() {
        return Holder.INSTANCE;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
