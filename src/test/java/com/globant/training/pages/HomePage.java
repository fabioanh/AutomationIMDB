package com.globant.training.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.globant.training.tools.AppProperties;

public class HomePage extends CommonPage<HomePage> {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		assertTrue(url.equals(AppProperties
				.getProperty(AppProperties.HOME_URL_KEY)),
				"This is the wrong page");
	}

	@Override
	protected void load() {
		driver.get("http://www.imdb.com");
	}
}
