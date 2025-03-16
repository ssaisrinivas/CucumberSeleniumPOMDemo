package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // 1.By Locater's
    private By userName = By.cssSelector("[placeholder=\"Username\"]");
    private By password = By.cssSelector("[placeholder=\"Password\"]");
    private By submit = By.cssSelector("[type=\"submit\"][value=\"Login\"]");
    private By forgotPasswordLink = By.xpath("//a[text()='Forgot your username/password?']");

    // 2. Constructor of the page class
    public LoginPage(WebDriver driver) {

	this.driver = driver;
    }

    // page actions

    public String getloginPageTitle() {
	return driver.getTitle();
    }

    public void getUrl(String url) {
	driver.get(url);
    }

    public boolean isForgotPasswordLinkPresent() {

	return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public void enterUserName(String userName) {

	driver.findElement(this.userName).sendKeys(userName);
    }

    public void enterPassword(String password) {
	driver.findElement(this.password).sendKeys(password);
    }

    public void clickOnLogin() {
	driver.findElement(submit).click();
    }

}
