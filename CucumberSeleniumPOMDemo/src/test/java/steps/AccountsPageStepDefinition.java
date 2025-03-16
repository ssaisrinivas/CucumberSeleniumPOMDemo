package steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pageObjects.AccountsPage;
import com.pageObjects.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageStepDefinition {

    private LoginPage lp = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) throws InterruptedException {
	List<Map<String, String>> credList = dataTable.asMaps();
	String userName = credList.get(0).get("username");
	String password = credList.get(0).get("password");
	DriverFactory.getDriver().get("https://sourceforge.net/auth/");
	accountsPage = lp.doLogin(userName, password);

    }

    @Given("user is on Accounts page")
    public void user_is_on_accounts_page() {
	String actualTitle = accountsPage.getaccountsPageTitle();
	System.out.println("Account Title is : " + actualTitle);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String actualTitle) {
	String expectedTitle = accountsPage.getaccountsPageTitle();
	Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Then("user gets accounts section")
    public void user_gets_accounts_section(DataTable sectionTable) {
	List<String> expectedaccountsSectionList = sectionTable.asList();
	System.out.println("Expected Account Section List : " + expectedaccountsSectionList);
	List<String> actualaccountsSectionList = accountsPage.getAccountSectionAccessibleNames();
	System.out.println("Actual Account Section List : " + actualaccountsSectionList);
	Assert.assertTrue(expectedaccountsSectionList.containsAll(actualaccountsSectionList));

    }

    @Then("accounts section count should be {int}")
    public void accounts_section_count_should_be(int expectedCount) {
	int actualCount = accountsPage.getAccountSectionAccessibleNamesSize();
	Assert.assertEquals(actualCount, expectedCount);
    }
}
