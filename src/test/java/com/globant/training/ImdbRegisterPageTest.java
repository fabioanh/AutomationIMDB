package com.globant.training;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.globant.training.pages.HomePage;
import com.globant.training.pages.RegisterPage;
import com.globant.training.tools.AppProperties;
import com.globant.training.tools.Inputs;

/**
 * Test for IMDB header.
 * 
 * @author fabio
 * 
 */
public class ImdbRegisterPageTest {

	private WebDriver driver;
	private RegisterPage registerPage;

	@BeforeGroups(groups = "suiteRegister")
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en");
		driver = new FirefoxDriver(profile);
	}

	@Test(groups = "suiteRegister")
	public void genderRadiosTest() {

		HomePage homePage = new HomePage(driver).get();
		registerPage = homePage.goToRegisterPage();

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

	@Test(groups = "suiteRegister")
	public void countryDropDownTest() {
		registerPage = new RegisterPage(driver).get();
		assertTrue(registerPage.getCountrySelect().getOptions().size() > 10,
				"Number of countries must be greather than 10");
	}

	@Test(groups = "suiteRegister")
	public void invalidMailMessageTest() {
		registerPage = new RegisterPage(driver).get();
		registerPage = registerPage.enterMail(Inputs
				.getProperty(Inputs.INVALID_MAIL));
		registerPage.submit();
		assertTrue(registerPage.errorMessagePresent(AppProperties
				.getProperty(AppProperties.INVALID_MAIL_MESSAGE_KEY)),
				"invalid mail message should be present");
	}

	@Test(groups = "suiteRegister")
	public void shortPasswordMessageTest() {
		registerPage = new RegisterPage(driver).get();
		registerPage = registerPage.enterPassword(Inputs
				.getProperty(Inputs.INVALID_SHORT_PASSWORD));
		registerPage.submit();
		assertTrue(
				registerPage
						.errorMessagePresent(AppProperties
								.getProperty(AppProperties.INVALID_SHORT_PASSWORD_MESSAGE_KEY)),
				"short password message should be present");
	}

	@AfterGroups(groups = "suiteRegister")
	public void tearDown() {
		driver.close();
	}
}
