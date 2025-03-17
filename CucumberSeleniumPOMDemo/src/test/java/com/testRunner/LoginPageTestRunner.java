package com.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
	"C:\\Users\\ssais\\git\\CucumberSeleniumPOMDemo\\CucumberSeleniumPOMDemo\\src\\test\\resources\\features\\" }, glue = {
		"steps", "ApplicationHooks" },

	plugin = { "pretty", "html:test-output/test-outputs.html", "json:test-output/test-outputs.json",
		"junit:test-output/test-outputs.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/" }, monochrome = true, dryRun = false)
//, tags = "@sanity"
public class LoginPageTestRunner {

}
