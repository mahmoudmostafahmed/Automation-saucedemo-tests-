package com.Automationtask.saucedemosite.utils.read_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
    private static final String ROOT_PATH = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String SauceConfiguration = ROOT_PATH.concat("saucedemo.properties");

    private ReadProperties() {
    }

    public static Properties setSauceCorporationConfig() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(SauceConfiguration);
        configProperties.load(inputStream);
        return configProperties;
    }
}
