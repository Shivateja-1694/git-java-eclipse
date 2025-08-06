package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	// Declares a static Properties object named 'prop'
    // 'static' means this object can be shared across all classes without creating an instance
	public static Properties prop;

    /**
     * Initializes and loads the properties from the config.properties file.
     * This method is called once to load all key-value pairs into memory.
     */
	public static Properties initProperties() {
		prop = new Properties(); // Creates an empty Properties object
		try {
			// Creates a FileInputStream to read from the properties file
            // This path is relative to the project structure
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
			FileInputStream fis2 = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/register.properties");
			FileInputStream fis3 = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/AssertionMessages.properties");

			// Loads the file content into the 'prop' object as key-value pairs
			prop.load(fis);
			prop.load(fis2);
			prop.load(fis3);
		} catch (IOException e) {
			// If there is an error (like file not found), it will print the reason
			System.out.println("❌ Unable to load config file: " + e.getMessage());
		}
		 // Returns the loaded Properties object
		return prop;
	}
	
    /**
     * Returns the value for the given key from the properties file.
     * Example: If key = "browser", it might return "chrome"
     */
	public static String getProperty(String key) {
		// If the properties object is not loaded yet, load it
		if (prop == null) {
			initProperties();
		}
		// Get and return the value for the given key
		return prop.getProperty(key);
	}

}
