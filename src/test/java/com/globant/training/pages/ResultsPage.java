package com.globant.training.pages;

import org.openqa.selenium.WebDriver;

import com.globant.training.tools.Titles;

public class ResultsPage extends CommonPage {

	public ResultsPage(WebDriver driver) {
		super(driver, Titles.getTitle(Titles.RESULTS_PAGE_TITLE_KEY));
	}
}
