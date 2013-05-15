package com.globant.training.pages;

import org.openqa.selenium.WebDriver;

import com.globant.training.tools.Titles;

public class HomePage extends CommonPage {

	public HomePage(WebDriver driver) {
		super(driver, Titles.getTitle(Titles.HOME_PAGE_TITLE_KEY));
	}

}
