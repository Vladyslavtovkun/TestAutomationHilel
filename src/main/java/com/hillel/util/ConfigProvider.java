package com.hillel.util;

import com.hillel.core.Browsers;

import java.io.IOException;
import java.util.Properties;

public final class ConfigProvider {
    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();


    public static final String BROWSER = prop.getProperty("browser");
    public static final String BASE_URL = prop.getProperty("base.url");

//    Api
    public static final String BASE_API_URL = prop.getProperty("base.api.url");
    public static final String PORT = prop.getProperty("port");
    public static final String PATH = prop.getProperty("path");

    public static final String REMOTE_ADDRESS = prop.getProperty("selenium-hub.url");

    private ConfigProvider(){}

    private static Properties initProperties() {
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load property file");
        }
        return properties;
    }
}
