package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    public Properties init_prop() {

	prop = new Properties();
	try (FileInputStream ip = new FileInputStream(
		"C:\\Users\\ssais\\git\\CucumberSeleniumPOMDemo\\CucumberSeleniumPOMDemo\\src\\test\\resources\\config\\config.properties")) {
	    prop.load(ip);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return prop;
    }
}
