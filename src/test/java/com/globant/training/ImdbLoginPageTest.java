package com.globant.training;

import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.training.pages.HomePage;
import com.globant.training.tools.Tools;

/**
 * Test for IMDB header.
 * 
 * @author fabio
 * 
 */
public class ImdbLoginPageTest {

	@DataProvider(name = "login-providers")
	public static Iterator<Object[]> getDataFromFile() throws Exception {
		return Tools.getIteratorForProperties("login-providers.properties");
	}

	private FirefoxDriver driver;
	private HomePage homePage;

	@BeforeTest(groups = "suiteLogin")
	public void setUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("intl.accept_languages", "en");
		driver = new FirefoxDriver(profile);
		homePage = new HomePage(driver).get();
		homePage.goToLogin();
	}

	@Test(groups = "suiteLogin")
	public void loginLinkTest() {
		assertTrue(homePage.isLoginWindowVisible(),
				"Login window should be visible");
	}

	@Test(groups = "suiteLogin", dataProvider = "login-providers")
	public void loginProvidersTest(String dataProvider) {
		List<String> providers = Arrays.asList(dataProvider);
		homePage.forceFactoryInitComponents();
		assertTrue(homePage.loginContainersPresent(providers),
				"The provider should be present - " + dataProvider);
	}

	@AfterTest(groups = "suiteLogin")
	public void tearDown() {
		driver.close();
	}
}
