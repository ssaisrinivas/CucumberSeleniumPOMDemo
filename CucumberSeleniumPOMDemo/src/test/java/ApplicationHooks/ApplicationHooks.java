package ApplicationHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    public ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
	ConfigReader configReader = new ConfigReader();
	prop = configReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {

	String browserName = prop.getProperty("browser");
	driverFactory = new DriverFactory();
	driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
	driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario sc) {
	if (sc.isFailed()) {
	    // take screenshot:
	    String screenshotName = sc.getName().replaceAll("", "_");
	    TakesScreenshot take = ((TakesScreenshot) driver);
	    byte[] sourcePath = take.getScreenshotAs(OutputType.BYTES);
	    sc.attach(sourcePath, "images/png", screenshotName);

	}

    }

}
