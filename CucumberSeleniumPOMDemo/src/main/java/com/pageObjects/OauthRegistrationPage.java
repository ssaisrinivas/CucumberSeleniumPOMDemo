package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OauthRegistrationPage {

    private WebDriver driver;

    // 1.By Locater's
    private By accountOauth = By.xpath("//*[@id='account_oauth']/a");
    private By applicationName = By.xpath("//input[@name='application_name'][@tabindex='6']");
    private By applicationDescription = By.xpath("//textarea[@name='application_description'][@tabindex='7']");
    private By redirectUrl_1 = By.xpath("//input[@name='redirect_url_1'][@tabindex='8']");
    private By redirectUrl_2 = By.xpath("//input[@name='redirect_url_2'][@tabindex='9']");
    private By redirectUrl_3 = By.xpath("//input[@name='redirect_url_3'][@tabindex='10']");
    private By registerNewApplication = By.xpath("//input[@value='Register new Application']");
    private By successMessage = By.cssSelector("div > div.content");
    private By deleteOauth = By.xpath("//input[@value='Delete App']");

    // 2. Constructor of the page class
    public OauthRegistrationPage(WebDriver driver) {
	this.driver = driver;
    }

    // page actions

    public String getOauthRegistrationPageTitle() {
	return driver.getTitle();
    }

    public void fillOauthRegistrationForm(String applicationName, String applicationDescription, String redirectUrl_1,
	    String redirectUrl_2, String redirectUrl_3) {

	driver.findElement(this.applicationName).sendKeys(applicationName);
	driver.findElement(this.applicationDescription).sendKeys(applicationDescription);
	driver.findElement(this.redirectUrl_1).sendKeys(redirectUrl_1);
	driver.findElement(this.redirectUrl_2).sendKeys(redirectUrl_2);
	driver.findElement(this.redirectUrl_3).sendKeys(redirectUrl_3);
    }

    public void navigateToOauth() {
	driver.findElement(accountOauth).click();
    }

    public void registerNewApplication() {
	driver.findElement(registerNewApplication).click();
    }

    public String successMessage() {

	return driver.findElement(successMessage).getText();
    }

    public void deleteRegistration() {

	driver.findElement(deleteOauth).click();
	driver.switchTo().alert().accept();
    }

    public boolean getPageSourceValue() {

	return driver.getPageSource().contains("Sai Srinivas Git ");
    }

}
