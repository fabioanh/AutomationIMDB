package com.globant.training.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

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

	public static Iterator<Object[]> getIteratorForProperties(
			String propertiesFile) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(propertiesFile));
		List<Object[]> data = new ArrayList<Object[]>();
		for (Object obj : props.values()) {
			data.add(new Object[] { obj });
		}
		return data.iterator();
	}
}
