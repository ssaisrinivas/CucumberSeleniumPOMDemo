package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

    private WebDriver driver;

    // 1.By Locater's
    private By userName = By.cssSelector("[placeholder=\"Username\"]");
    private By password = By.cssSelector("[placeholder=\"Password\"]");
    private By submit = By.cssSelector("[type=\"submit\"][value=\"Login\"]");
    private By forgotPasswordLink = By.xpath("//a[text()='Forgot your username/password?']");
    private By meToggle = By.xpath("//a[contains(text(),'Me ▾')]");
    private By accountSettings = By.xpath("//ul[@id='account-menu']//a[normalize-space()='Account Settings']");

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

    public void moveToMeToggle() throws InterruptedException {
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(meToggle)).perform();

    }

    public void clickOnaccountSettings() throws InterruptedException {
	driver.findElement(accountSettings).click();
    }

    public AccountsPage doLogin(String userNaame, String password) throws InterruptedException {
	System.out.println("Login With :" + userNaame + "  " + "Password : " + password);
	driver.findElement(this.userName).sendKeys(userNaame);
	driver.findElement(this.password).sendKeys(password);
	driver.findElement(submit).click();
	moveToMeToggle();
	clickOnaccountSettings();
	return new AccountsPage(driver);

    }

}
