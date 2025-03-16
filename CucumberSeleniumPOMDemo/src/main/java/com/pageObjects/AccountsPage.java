package com.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

    private WebDriver driver;

    public AccountsPage(WebDriver driver) {
	this.driver = driver;
    }

    private By accountSectionAccessibleNames = By.cssSelector("fieldset.preferences a");

    public List<String> getAccountSectionAccessibleNames() {

	List<WebElement> elements = driver.findElements(accountSectionAccessibleNames);
	List<String> elementNameList = new ArrayList<String>();
	for (WebElement webElement : elements) {
	    String text = webElement.getAccessibleName();
	    elementNameList.add(text);
	    System.out.println(text);
	}
	return elementNameList;
    }

    public int getAccountSectionAccessibleNamesSize() {

	return driver.findElements(accountSectionAccessibleNames).size();
    }

    public String getaccountsPageTitle() {
	return driver.getTitle();
    }
}
