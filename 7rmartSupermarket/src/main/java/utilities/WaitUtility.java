package utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public static final long IMPLICIT_WAIT = 5;
	public static final long EXPLICIT_WAIT = 20;
	public static final long FLUENT_WAIT = 20;
	public static final long POLLING_TIME = 2;

	public void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
	
	public void waitForClickUsingExplicitWait(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	
	public void waitForUntilTextPresentInElement(WebDriver driver, WebElement target, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(target, value));
	}
	
	public void waitForAlertisDisplayedUsingExplicitWait(WebDriver driver, WebElement target, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForUntilElementToBeClickableUsingFluentWait(WebDriver driver,WebElement target)
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
	            .pollingEvery(Duration.ofSeconds(3))
	            .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(target));
	}
	
	public void waitForUntilElementToBePresentInElementUsingFluentWait(WebDriver driver,WebElement target)
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
	            .pollingEvery(Duration.ofSeconds(POLLING_TIME))
	            .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(target));
	}
	
	public void waitForAlertisDisplayedUsingFluentWait(WebDriver driver, WebElement target)
	{
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(FLUENT_WAIT))
	            .pollingEvery(Duration.ofSeconds(POLLING_TIME))
	            .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
	}
	
}
