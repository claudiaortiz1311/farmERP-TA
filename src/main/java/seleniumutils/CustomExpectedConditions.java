package seleniumutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

//Add this class to avoid defining waits all the time.

public class CustomExpectedConditions {
	private static String AJAX_ACTIVE_CONNECTIONS = "var i = 0; if(!(typeof jQuery == 'undefined')) { i += jQuery.active; } if(!(typeof Ajax == 'undefined')) { i += Ajax.activeRequestCount; } return i == 0;";
	
	public static ExpectedCondition<Boolean> noActiveConnections = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver d) {
			JavascriptExecutor jsExec = (JavascriptExecutor) d;
			return (Boolean) jsExec.executeScript(AJAX_ACTIVE_CONNECTIONS);
		}
	};

}
