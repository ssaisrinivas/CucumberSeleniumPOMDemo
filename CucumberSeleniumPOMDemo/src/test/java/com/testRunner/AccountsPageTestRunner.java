package com.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
	"C:\\Users\\ssais\\git\\CucumberSeleniumPOMDemo\\CucumberSeleniumPOMDemo\\src\\test\\resources\\features\\AccountsPage.feature" }, glue = {
		"steps", "ApplicationHooks" },

	plugin = { "pretty", "html:testOutputs/test-outputs.html", "json:testOutputs/test-outputs.json",
		"junit:testOutputs/test-outputs.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true, dryRun = false)
//, tags = "@sanity"
public class AccountsPageTestRunner {

}