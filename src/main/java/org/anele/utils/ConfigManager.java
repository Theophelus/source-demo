package org.anele.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    protected static Properties properties;

    public ConfigManager() {
        properties = new Properties();
        loadProperties();
    }

    //load properties
    public void loadProperties() {
        //define a path for config.properties file
        String path = "src/main/resources/config.properties";
        try (FileInputStream stream = new FileInputStream(path)) {
            if (stream == null)
                throw new IOException("unable to locate provided file path: " + path);
            //load file properties
            properties.load(stream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //getters for config file properties
    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

}
