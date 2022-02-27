package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    private static final String CONFIG_PATH = "src/test/resources/config.properties";
    private static Properties PROPERTIES = null;

    private static void readProperties() {
        PROPERTIES = System.getProperties();
        try {
            PROPERTIES.load(new FileInputStream(new File(CONFIG_PATH)));
        } catch (IOException exception) {
            System.out.println("WARNING: There is no property file " + CONFIG_PATH);
        }
    }

    public static String get(String propertyKey) {
        if (PROPERTIES == null) {
            readProperties();
        }
        return PROPERTIES.getProperty(propertyKey);
    }

    public static String getEnv(String key) {
        String envVar = System.getenv(key);
        if (envVar == null) {
            envVar = System.getProperty(key);
        }
        return envVar;
    }
}
