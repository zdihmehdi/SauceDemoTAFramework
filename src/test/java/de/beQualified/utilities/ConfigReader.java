package de.beQualified.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    public ConfigReader() {
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("configuration.properties")) {
            if (input == null) {
                logger.error("Sorry, unable to find configuration.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }
}
