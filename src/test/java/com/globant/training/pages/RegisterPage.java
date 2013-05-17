package com.globant.training.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.globant.training.tools.AppProperties;

public class RegisterPage extends CommonPage<RegisterPage> {

	@FindBy(id = "gender_m")
	private WebElement maleGenderRadio;

	@FindBy(id = "gender_f")
	private WebElement femaleGenderRadio;

	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		assertTrue(url.equals(AppProperties
				.getProperty(AppProperties.HOME_URL_KEY)),
				"This is the wrong page");
	}

	@Override
	protected void load() {
		driver.get(AppProperties.getProperty(AppProperties.REGISTER_URL_KEY));
	}

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	public RegisterPage selectMaleGender() {
		maleGenderRadio.click();
		return this;
	}

	public RegisterPage selectFemaleGender() {
		femaleGenderRadio.click();
		return this;
	}

	public boolean isFemaleGenderSelected() {
		return femaleGenderRadio.isSelected();
	}

	public boolean isMaleGenderSelected() {
		return maleGenderRadio.isSelected();
	}

}
