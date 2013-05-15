package com.globant.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonPage {
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

	protected final WebDriver driver;
	protected final String title;
	protected final WebDriverWait wait;

	public CommonPage(WebDriver driver, String title) {
		this.driver = driver;
		this.title = title;
		wait = new WebDriverWait(driver, 10);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkCorrectPage();
	}

	public ResultsPage commonSearch(String key) {
		return new ResultsPage(driver);
	}

	protected void checkCorrectPage() {
		if (!driver.getTitle().trim().equals(title)) {
			throw new IllegalStateException("This is not the right page - "
					+ driver.getCurrentUrl() + " - Title: "
					+ driver.getTitle().trim() + " --- Should be: " + title);
		}
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

	public Select getFilterDropDown() {
		return new Select(searchDropDownFilter);
	}
}
