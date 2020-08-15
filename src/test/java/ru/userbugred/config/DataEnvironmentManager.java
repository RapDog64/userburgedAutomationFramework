package ru.userbugred.config;

import java.util.ResourceBundle;

public class DataEnvironmentManager {

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }

}
