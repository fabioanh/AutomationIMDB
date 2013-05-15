package com.globant.training;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.training.pages.HomePage;
import com.globant.training.tools.AppProperties;
import com.globant.training.tools.Tools;

import static org.testng.Assert.assertTrue;

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
		driver.get(AppProperties.getProperty(AppProperties.HOME_URL_KEY));
	}

	/**
	 * Checks whether the logo and search components are present or not.
	 */
	@Test
	public void presentSearchComponentsTest() {
		HomePage homePage = new HomePage(driver);
		PageFactory.initElements(driver, homePage);

		assertTrue(homePage.isLogoPresent(), "The logo is not present");
		assertTrue(homePage.isSearchButtonPresent(),
				"The search button is not present");
		assertTrue(homePage.isSearchFieldPresent(),
				"The search field is not present");
		assertTrue(homePage.isSearchDropDownFilterPresent(),
				"The search drop down is not present");

		System.out.println("presentSearchComponentsTest finish");
	}

	@Test
	public void dropDownOptionsTest() {
		HomePage homePage = new HomePage(driver);
		PageFactory.initElements(driver, homePage);

		List<String> dropDownNeededFilters = Arrays.asList(AppProperties
				.getProperty(AppProperties.DROP_DOWN_FILTER_OPTIONS_KEY).split(
						","));

		assertTrue(Tools.doesDropDownContainsOptions(
				homePage.getFilterDropDown(), dropDownNeededFilters),
				"Drop Down should contain all the options: "
						+ dropDownNeededFilters);

		System.out.println("dropDownOptionsTest finish");
	}

	@Test
	public void presentLinksTest() {
		HomePage homePage = new HomePage(driver);
		PageFactory.initElements(driver, homePage);

		assertTrue(homePage.isRegisterLinkPresent(),
				"The Register link is not present");
		assertTrue(homePage.isLoginLinkPresent(),
				"The Login link is not present");
		assertTrue(homePage.isHelpLinkPresent(), "The Help link is not present");

		System.out.println("presentLinksTest finish");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
