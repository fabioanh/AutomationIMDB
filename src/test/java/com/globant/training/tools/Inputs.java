package com.globant.training.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Inputs {

	private static final String INPUTS_FILE = "inputs.properties";
	private static final Properties properties = new Properties();
	public static final String INVALID_MAIL = "invalidMail";
	public static final String INVALID_SHORT_PASSWORD = "invalidShortPassword";

	public static final String getProperty(String key) {
		if (properties.isEmpty()) {
			try {
				properties.load(new FileInputStream(INPUTS_FILE));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties.getProperty(key);
	}
}
