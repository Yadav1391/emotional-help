package com.epam.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties PROPERTIES = new Properties();
    public static final String ENV_CONFIG_PATH = System.getProperty("user.dir")
            +"//src//test//resources//envConfig//";

    private ConfigReader(){}
    public static String getValueFromProperties(String envName, String key) throws IOException {
        FileInputStream file = new FileInputStream(ENV_CONFIG_PATH + envName + ".properties");
        PROPERTIES.load(file);
        return PROPERTIES.getProperty(key);
    }
}
