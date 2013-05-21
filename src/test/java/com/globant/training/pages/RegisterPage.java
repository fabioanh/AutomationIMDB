package com.globant.training.pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.globant.training.tools.AppProperties;

public class RegisterPage extends CommonPage<RegisterPage> {

	@FindBy(id = "gender_m")
	private WebElement maleGenderRadio;

	@FindBy(id = "gender_f")
	private WebElement femaleGenderRadio;

	@FindBy(xpath = "//select[@id='country']")
	private WebElement countryDropDown;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailInput;

	@FindBy(className = "reg_error")
	private List<WebElement> errorMessages;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement registerButton;

	@FindBy(xpath = "//input[@id='password1']")
	private WebElement password1Input;

	@FindBy(xpath = "//input[@id='password2']")
	private WebElement password2Input;

	@Override
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		assertTrue(url.equals(AppProperties
				.getProperty(AppProperties.REGISTER_URL_KEY)),
				"This is the wrong page");
	}

	@Override
	protected void load() {
		driver.get(AppProperties.getProperty(AppProperties.REGISTER_URL_KEY));
	}

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Selects the radio with the male gender option
	 * 
	 * @return
	 */
	public RegisterPage selectMaleGender() {
		maleGenderRadio.click();
		return this;
	}

	/**
	 * Selects the radio with the female gender option
	 * 
	 * @return
	 */
	public RegisterPage selectFemaleGender() {
		femaleGenderRadio.click();
		return this;
	}

	/**
	 * Check if radio option for female gender is selected
	 * 
	 * @return
	 */
	public boolean isFemaleGenderSelected() {
		return femaleGenderRadio.isSelected();
	}

	/**
	 * Check if radio option for male gender is selected
	 * 
	 * @return
	 */
	public boolean isMaleGenderSelected() {
		return maleGenderRadio.isSelected();
	}

	/**
	 * Get the country drop-down as a Select object
	 * 
	 * @return
	 */
	public Select getCountrySelect() {
		return new Select(countryDropDown);
	}

	/**
	 * Checks whether the given error message is present in the errors of the
	 * page or not
	 * 
	 * @param errorMessage
	 * @return
	 */
	public boolean errorMessagePresent(String errorMessage) {
		for (WebElement we : errorMessages) {
			if (we.getText().equals(errorMessage)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Puts the input string into the Mail field of the register form
	 * 
	 * @param mail
	 * @return
	 */
	public RegisterPage enterMail(String mail) {
		this.emailInput.sendKeys(mail);
		return this;
	}

	/**
	 * Submits the form by clicking the register button
	 */
	public void submit() {
		registerButton.click();
	}

	/**
	 * Enter password in both password fields of the register form
	 * 
	 * @param password
	 * @return
	 */
	public RegisterPage enterPassword(String password) {
		this.password1Input.sendKeys(password);
		this.password2Input.sendKeys(password);
		return this;
	}

}
