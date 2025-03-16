package steps;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pageObjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDefinitions {

    private LoginPage lp = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {

	lp.getUrl("https://sourceforge.net/auth/");
    }

    @When("user gets the title of the login page")
    public void user_gets_the_title_of_the_login_page() throws InterruptedException {
	System.out.println("Login Page Title is :  " + lp.getloginPageTitle());
    }

    @Then("Login page title should be {string}")
    public void Login_page_title_should_be(String actualTitle) throws InterruptedException {
	String expectedTitel = lp.getloginPageTitle();
	System.out.println(expectedTitel);
	Assert.assertEquals(expectedTitel, actualTitle);
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() throws InterruptedException {
	Assert.assertTrue(lp.isForgotPasswordLinkPresent());
	if (lp.isForgotPasswordLinkPresent()) {
	    System.out.println("Forgot password is Link displayd ! ");
	} else {
	    System.out.println("Forgot password is Link Not displayd !!!! ");
	}
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) throws InterruptedException {

	// Thread.sleep(2000);
	lp.enterUserName(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) throws InterruptedException {
	lp.enterPassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() throws InterruptedException {
	lp.clickOnLogin();
    }

    @Then("user gets the title of the account page")
    public void user_gets_the_title_of_the_account_page() throws InterruptedException {
	Thread.sleep(2000);
	System.out.println("Login Page Title is :  " + lp.getloginPageTitle());
    }

    @Then("Account page title should be {string}")
    public void Account_page_title_should_be(String actualTitle) throws InterruptedException {
	String expectedTitel = lp.getloginPageTitle();
	Assert.assertEquals(expectedTitel, actualTitle);
    }
}
