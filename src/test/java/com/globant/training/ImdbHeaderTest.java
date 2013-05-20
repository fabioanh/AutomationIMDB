package com.globant.training;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import com.globant.training.pages.HomePage;
import com.globant.training.tools.AppProperties;
import com.globant.training.tools.Tools;

/**
 * Test for IMDB header.
 * 
 * @author fabio
 * 
 */
public class ImdbHeaderTest {

	private FirefoxDriver driver;
	private HomePage homePage;

	@BeforeGroups(groups = "suiteHeader")
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en");
		driver = new FirefoxDriver(profile);
		homePage = new HomePage(driver).get();
	}

	/**
	 * Checks whether the logo and search components are present or not.
	 */
	@Test(groups = "suiteHeader")
	public void presentSearchComponentsTest() {
		assertTrue(homePage.isLogoPresent(), "The logo is not present");
		assertTrue(homePage.isSearchButtonPresent(),
				"The search button is not present");
		assertTrue(homePage.isSearchFieldPresent(),
				"The search field is not present");
		assertTrue(homePage.isSearchDropDownFilterPresent(),
				"The search drop down is not present");

		System.out.println("presentSearchComponentsTest finish");
	}

	@Test(groups = "suiteHeader")
	public void dropDownOptionsTest() {
		List<String> dropDownNeededFilters = Arrays.asList(AppProperties
				.getProperty(AppProperties.DROP_DOWN_FILTER_OPTIONS_KEY).split(
						","));

		assertTrue(Tools.doesDropDownContainsOptions(
				homePage.getFilterDropDown(), dropDownNeededFilters),
				"Drop Down should contain all the options: "
						+ dropDownNeededFilters);

		System.out.println("dropDownOptionsTest finish");
	}

	@Test(groups = "suiteHeader")
	public void presentLinksTest() {
		assertTrue(homePage.isRegisterLinkPresent(),
				"The Register link is not present");
		assertTrue(homePage.isLoginLinkPresent(),
				"The Login link is not present");
		assertTrue(homePage.isHelpLinkPresent(), "The Help link is not present");

		System.out.println("presentLinksTest finish");
	}

	@AfterGroups(groups = "suiteHeader")
	public void tearDown() {
		driver.close();
	}
}
