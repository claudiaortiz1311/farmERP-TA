package seleniumutils;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	private static <T> T waitForCondition(WebDriver driver, Integer timeOutSeconds, Function<WebDriver, T> condition) {
		return new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds))
				.ignoring(WebDriverException.class)
				.until(condition);
	}
	
	public void waitForElementToBeVisible(WebDriver driver, final WebElement element, int seconds) {
		waitForCondition(driver, seconds, d-> element.isDisplayed());
	}
	
	public void waitForNoActiveConnections(WebDriver driver, Integer timeOutSeconds) {
		waitForCondition(driver, timeOutSeconds, CustomExpectedConditions.noActiveConnections);
	}
	
	public void waitForAlert(WebDriver driver, Integer timeOutSeconds) {
		waitForCondition(driver, timeOutSeconds, ExpectedConditions.alertIsPresent());
	}

}
