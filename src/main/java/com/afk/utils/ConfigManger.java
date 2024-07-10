package com.afk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManger {
    private static ConfigManger manager;
    private static final Properties prop = new Properties();

    private ConfigManger() throws IOException {
        // Use the class loader to load the properties file from the resources folder
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        if (inputStream != null) {
            prop.load(inputStream);
            inputStream.close();
        } else {
            throw new IOException("Properties file not found");
        }
    }

    public static ConfigManger getInstance() {
        if (manager == null) {
            synchronized (ConfigManger.class) {
                try {
                    manager = new ConfigManger();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return manager;
    }

    public String getString(String key) {
        return System.getProperty(key, prop.getProperty(key));
    }
}
