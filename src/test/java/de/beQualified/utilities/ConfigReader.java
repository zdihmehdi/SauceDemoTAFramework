package de.beQualified.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This class is used to read the configuration.properties file to retrieve the browser name.
 */
public class ConfigReader {
    private final Properties properties = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    public ConfigReader() {
        loadProperties();
    }

    /**
     * This method is used to load the configuration.properties file
     */
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

    /**
     * This method is used to retrieve a specific key from the configuration.properties file
     *
     * @param key The name of the key.
     * @return The value associated with the key.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    /**
     * This method is used to retrieve the browser key value from the configuration.properties file.
     *
     * @return The value associated with the browser key.
     */
    public String getBrowser() {
        return properties.getProperty("browser");
    }
}
