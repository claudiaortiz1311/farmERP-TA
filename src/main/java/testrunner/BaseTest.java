package testrunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import asserts.Validate;
import driver.DriverFactory;
import driver.DriverManager;
import listeners.TestMethodListener;
import logging.Logging;
import utils.Constants;

@Listeners(TestMethodListener.class)
public abstract class BaseTest implements Logging {
	
	protected DriverManager driverManager;
	protected WebDriver driver;
	protected Validate validate;
	
	@BeforeClass
	@Parameters({"driverName"})
	protected void setup(@Optional("CHROME") String driverName) {
		getLogger().info("Starting a Selenium WebDriver instance. ");
		driverManager = DriverFactory.valueOf(driverName).getDriverManager();
		driver = this.getDriver();
		validate = new Validate(this.getDriver());
		
		driver.navigate().to(Constants.getContextUrl());
	}
	
	public Validate getValidator() {
		return validate;
	}
	
	@AfterMethod
	protected void afterMethod() {
		
	}
	
	@AfterClass
	protected void cleanUp() {
		// Reporter.
		getLogger().info("Closing Selenium WebDriver instance .");
		driverManager.quitDriver();
	}
	
	protected WebDriver getDriver() {
		return driverManager.getDriver();
	}

}
