package com.globant.training.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Titles {

	public static final String RESULTS_PAGE_TITLE_KEY = "resultsPage";
	public static final String HOME_PAGE_TITLE_KEY = "homePage";
	public static final String REGISTER_PAGE_TITLE_KEY = "registerPage";

	private static final String TITLES_FILE = "titles.properties";
	private static final Properties titles = new Properties();

	public static final String getTitle(String key) {
		if (titles.isEmpty()) {
			try {
				titles.load(new FileInputStream(TITLES_FILE));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return titles.getProperty(key);
	}
}
