package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import seleniumutils.Waits;

//All other pages where the test will run be inherited from BasePage(*extends BasePage) and the test (*extends BaseTest)
public abstract class BasePage {
	
	protected WebDriver driver;
	protected Waits w = new Waits();
	
	public BasePage(WebDriver driver) {
		setDriver(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void navigateForward() {
		driver.navigate().forward();
	}

}
