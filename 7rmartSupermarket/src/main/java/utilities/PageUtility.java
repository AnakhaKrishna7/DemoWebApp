package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
				public void selectValueFromDropDownUsingIndex(WebElement element, int index) {
					Select select = new Select(element);
					select.selectByIndex(index);
				}
				
				public void selectUserTypeFromDropDownUsingValue(WebElement element, String value) {
					Select select = new Select(element);
					select.selectByValue(value);
				}
				public void selectCategoryTypeFromDropDownUsingIndex(WebElement element, int index) {
					Select select = new Select(element);
					select.selectByIndex(index);
				}
				
				public void scrollTODown(WebDriver driver)
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,200)", "");
				
				}
				
				public void scrollToUp(WebDriver driver)
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0,-200)", "");
				
				}
				public void completeScrollDown(WebDriver driver)
				{
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
				}
				
				public String alertTextIsFetching(WebElement element ,WebDriver driver)
				{
					String alertBoxText = driver.switchTo().alert().getText();
					return alertBoxText;
				}
				
				public void actionsClass(WebElement element, WebDriver driver)
				{
					Actions actions = new Actions(driver);
					actions.moveToElement(element).build().perform();	
				}
				
				public void actionClassForDoubleClick(WebElement element, WebDriver driver)
				{
					Actions actions = new Actions(driver);
					actions.doubleClick(element).perform();
				}
				
				public void actionClassForContextClick(WebElement element, WebDriver driver)
				{
					Actions actions = new Actions(driver);
					actions.contextClick(element).perform();
				}
				public void actionClassForDragandDrop(WebElement element,WebElement element2, WebDriver driver)
				{
					Actions actions = new Actions(driver);
					actions.dragAndDrop(element, element2).build().perform();
				}
			

	
}
