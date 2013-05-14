package com.globant.training.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonPage {
	@FindBy(xpath = "//input[@id=\"navbar-query\"]")
	protected WebElement searchField;

	@FindBy(xpath = "//input[@id=\"quicksearch\"]")
	protected WebElement searchSelect;

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
			// TODO Auto-generated catch block
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
}
