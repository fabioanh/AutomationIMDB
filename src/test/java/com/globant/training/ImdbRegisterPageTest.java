package com.globant.training;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.training.pages.HomePage;
import com.globant.training.pages.RegisterPage;

/**
 * Test for IMDB header.
 * 
 * @author fabio
 * 
 */
public class ImdbRegisterPageTest {

	private WebDriver driver;

	@BeforeMethod(groups = "suiteRegister")
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en");
		driver = new FirefoxDriver(profile);
	}

	@Test(groups = "suiteRegister")
	public void genderRadiosTest() {
		HomePage homePage = new HomePage(driver).get();

		RegisterPage registerPage = homePage.goToRegisterPage();

		registerPage.selectFemaleGender();
		assertTrue(
				registerPage.isFemaleGenderSelected()
						&& !registerPage.isMaleGenderSelected(),
				"Both gender radio buttons should not be selected at the same time");

		registerPage.selectMaleGender();
		assertTrue(
				!registerPage.isFemaleGenderSelected()
						&& registerPage.isMaleGenderSelected(),
				"Both gender radio buttons should not be selected at the same time");
	}

	@AfterMethod(groups = "suiteRegister")
	public void tearDown() {
		driver.close();
	}
}
