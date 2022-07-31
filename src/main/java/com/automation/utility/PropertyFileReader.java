package com.automation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	private static Properties prop = null;

	public static String MIN_TIMEOUT = PropertyFileReader.getProperty("min.timeout");
	public static String MAX_TIMEOUT = PropertyFileReader.getProperty("max.timeout");
	public static String SHORT_WAIT = PropertyFileReader.getProperty("wait.short");
	public static String LONG_WAIT = PropertyFileReader.getProperty("wait.long");
	public static String APP_URL = PropertyFileReader.getProperty("application.url");
	public static String USER_EMAIL = PropertyFileReader.getProperty("user.email");
	public static String USER_PASSWD = PropertyFileReader.getProperty("user.password");
	public static String USER_DIFFERENT_EMAIL = PropertyFileReader.getProperty("user.diffrent.email");
	public static String USER_DIFFERENT_CONF_EMAIL = PropertyFileReader.getProperty("user.diffrent.confirmemail");
	public static String INVALID_CREDS_MESSAGE = PropertyFileReader.getProperty("error.invalid.credential.message");

	private PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("/serenity.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String getProperty(String key) {
		try {
			if (prop == null) {
				new PropertyFileReader();
			}
		} catch (Exception e) {
			new PropertyFileReader();
		}
		String property = prop.getProperty(key);
		return property != null ? property.trim() : property;
	}

	private static Properties loadProperties() {
		try {
			if (prop == null) {
				new PropertyFileReader();
			}

		} catch (Exception e) {
			new PropertyFileReader();
		}
		return prop;
	}
}
