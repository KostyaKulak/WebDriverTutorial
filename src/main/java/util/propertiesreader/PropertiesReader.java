package util.propertiesreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static util.logger.MyLogger.LOGGER;

public class PropertiesReader {
    private static final String PROPERTIES_FILE_NAME = "/Users/kanstantsin_kulak/IdeaProjects/WebDriverTutorial/src/main/resources/test.properties";
    private static Properties property = new Properties();

    public static String getPropertyValue(String propertyName) {
        loadProperties(propertyName);
        String propertyValue = null;
        propertyValue = property.getProperty(propertyName);
        return propertyValue;
    }

    private static void loadProperties(String propertyName) {
        try {
            InputStream inputStream = new FileInputStream(PROPERTIES_FILE_NAME);
            property.load(inputStream);
        } catch (IOException e) {
           LOGGER.error(e.getMessage());
        }
    }
}