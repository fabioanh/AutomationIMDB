package com.globant.training.tools;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Tools {

	public static final boolean doesDropDownContainsOptions(Select select,
			List<String> options) {
		List<String> dropDownTexts = new ArrayList<String>();
		for (WebElement we : select.getOptions()) {
			dropDownTexts.add(we.getText());
		}
		return dropDownTexts.containsAll(options);
	}
}
