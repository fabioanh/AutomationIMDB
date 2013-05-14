package com.globant.training;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Test for IMDB header.
 * 
 * @author fabio
 * 
 */
public class ImdbHeaderTest {

	private FirefoxDriver driver;

	@BeforeMethod
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en");
		driver = new FirefoxDriver(profile);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
