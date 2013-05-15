package com.globant.training.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.training.tools.Titles;

public class RegisterPage extends CommonPage {

	@FindBy(className = "reg_radio")
	private List<WebElement> genderRadios;

	public RegisterPage(WebDriver driver) {
		super(driver, Titles.getTitle(Titles.REGISTER_PAGE_TITLE_KEY));
	}

}
