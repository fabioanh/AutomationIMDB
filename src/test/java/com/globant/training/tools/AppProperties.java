package com.globant.training.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {

	private static final String APP_PROPERTIES_FILE = "app-properties.properties";
	private static final Properties properties = new Properties();
	public static final String HOME_URL_KEY = "homeUrl";
	public static final String REGISTER_URL_KEY = "registerUrl";
	public static final String DROP_DOWN_FILTER_OPTIONS_KEY = "dropDownFilterOptions";
	public static final String INVALID_MAIL_MESSAGE_KEY = "invalidMailMessage";
	public static final String INVALID_SHORT_PASSWORD_MESSAGE_KEY = "shortPasswordMessage";

	public static final String getProperty(String key) {
		if (properties.isEmpty()) {
			try {
				properties.load(new FileInputStream(APP_PROPERTIES_FILE));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties.getProperty(key);
	}
}
