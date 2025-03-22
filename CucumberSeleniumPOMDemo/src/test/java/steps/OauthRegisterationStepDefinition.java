package steps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import com.factory.DriverFactory;
import com.pageObjects.OauthRegistrationPage;
import com.utilities.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OauthRegisterationStepDefinition {

    private OauthRegistrationPage oauth = new OauthRegistrationPage(DriverFactory.getDriver());
    private ExcelReader excelReader;

    @Given("user navigates to OAuth2 page")
    public void user_navigates_to_o_auth2_page() throws InterruptedException {
	System.out.println("user_navigates_to_o_auth2_page");
	oauth.navigateToOauth();
	System.out.println(oauth.getOauthRegistrationPageTitle());
	Thread.sleep(2000);
    }

    @When("user fills the form from given sheetname {string} and rownumber {int}")
    public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, int rowNumber)
	    throws InvalidFormatException, IOException, InterruptedException {

	excelReader = new ExcelReader();
	Thread.sleep(2000);
	boolean value = oauth.getPageSourceValue();

	if (value) {
	    oauth.deleteRegistration();
	    Thread.sleep(3000);
	} else {
	    Thread.sleep(3000);
	    List<Map<String, String>> testData = excelReader.getData(
		    "C:\\Users\\ssais\\git\\CucumberSeleniumPOMDemo\\CucumberSeleniumPOMDemo\\OauthRegisteration.xlsx",
		    sheetName);
	    String Application_Name = testData.get(rowNumber).get("Application_Name");
	    String Application_Description = testData.get(rowNumber).get("Application_Description");
	    String redirectUrl_1 = testData.get(rowNumber).get("redirectUrl_1");
	    String redirectUrl_2 = testData.get(rowNumber).get("redirectUrl_2");
	    String redirectUrl_3 = testData.get(rowNumber).get("redirectUrl_3");

	    oauth.fillOauthRegistrationForm(Application_Name, Application_Description, redirectUrl_1, redirectUrl_2,
		    redirectUrl_3);
	}
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
	oauth.registerNewApplication();
    }

    @Then("it shows a successful message {string}")
    public void it_shows_a_successful_message(String expectedMessage) throws InterruptedException {
	Thread.sleep(2000);
	String actualMessage = oauth.successMessage();
	oauth.deleteRegistration();
	Assert.assertEquals(actualMessage, expectedMessage);

    }

}
