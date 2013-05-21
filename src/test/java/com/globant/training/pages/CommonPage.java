package com.globant.training.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonPage<T extends CommonPage<T>> extends
		LoadableComponent<T> {
	@FindBy(xpath = "//input[@id=\"navbar-query\"]")
	protected WebElement searchField;

	@FindBy(xpath = "//select[@id=\"quicksearch\"]")
	protected WebElement searchDropDownFilter;

	@FindBy(id = "home_img")
	protected WebElement logo;

	@FindBy(id = "navbar-submit-button")
	protected WebElement searchButton;

	@FindBy(linkText = "Register")
	protected WebElement registerLink;

	@FindBy(linkText = "Login")
	protected WebElement loginLink;

	@FindBy(linkText = "Help")
	protected WebElement helpLink;

	@FindBy(id = "cboxWrapper")
	protected WebElement loginContainer;

	@FindBy(className = "oauth-link")
	protected List<WebElement> loginLinkProviders;

	protected final WebDriver driver;

	protected final WebDriverWait wait;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public ResultsPage commonSearch(String key) {
		// TODO: Add logic to do the search
		return new ResultsPage(driver);
	}

	/**
	 * Checks whether the Logo is present or not
	 * 
	 * @return
	 */
	public boolean isLogoPresent() {
		return logo != null;
	}

	/**
	 * Checks whether the search button is present or not
	 * 
	 * @return
	 */
	public boolean isSearchButtonPresent() {
		return searchButton != null;
	}

	/**
	 * Checks whether the search field is present or not
	 * 
	 * @return
	 */
	public boolean isSearchFieldPresent() {
		return searchField != null;
	}

	/**
	 * Checks whether the register login is present or not
	 * 
	 * @return
	 */
	public boolean isRegisterLinkPresent() {
		return registerLink != null;
	}

	/**
	 * Checks whether the login link is present or not
	 * 
	 * @return
	 */
	public boolean isLoginLinkPresent() {
		return loginLink != null;
	}

	/**
	 * Checks whether the help link is present or not
	 * 
	 * @return
	 */
	public boolean isHelpLinkPresent() {
		return helpLink != null;
	}

	/**
	 * Checks whether the search drop down is present or not
	 * 
	 * @return
	 */
	public boolean isSearchDropDownFilterPresent() {
		return searchDropDownFilter != null;
	}

	/**
	 * Gets the drop down filter of the search bar
	 * 
	 * @return
	 */
	public Select getFilterDropDown() {
		return new Select(searchDropDownFilter);
	}

	/**
	 * Clicks the Register link
	 * 
	 * @return
	 */
	public RegisterPage goToRegisterPage() {
		registerLink.click();
		return new RegisterPage(driver).get();
	}

	/**
	 * Clicks the Login link
	 * 
	 * @return
	 */
	public void goToLogin() {
		loginLink.click();
	}

	/**
	 * Checks whether the login component is visible or not
	 * 
	 * @return
	 */
	public boolean isLoginWindowVisible() {
		return loginContainer.isDisplayed();
	}

	public void forceFactoryInitComponents() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Checks whether all providers given in the input list are available or not
	 * checking by its text
	 * 
	 * @param providers
	 * @return
	 */
	public boolean loginContainersPresent(List<String> providers) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.className("cboxIframe")));
		driver.switchTo().frame(driver.findElement(By.className("cboxIframe")));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.className("oauth-link")));
		loginLinkProviders = driver.findElements(By.className("oauth-link"));
		List<String> relLoginLinks = new ArrayList<String>();
		for (WebElement we : loginLinkProviders) {
			relLoginLinks.add(we.getText());
		}
		driver.switchTo().defaultContent();
		return relLoginLinks.containsAll(providers);
	}
}
