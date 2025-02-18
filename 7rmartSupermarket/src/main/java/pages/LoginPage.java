package pages;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']") WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']") WebElement passwordField;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']") WebElement loginButton;
	@FindBy(xpath = "//p[text()='Admin Users']") WebElement TileisAvilable;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']") WebElement alertisAvilable;


	public LoginPage enterUserNameOnUserNameField(String UserName){
		userNameField.sendKeys(UserName);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String Password){
		passwordField.sendKeys(Password);
		return this;
	}
	
	public LoginPage clickOnLoginButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click(); 
		return this;
	}
	
	 public boolean OnDasboardTileIsAvailable() {
     	return TileisAvilable.isDisplayed();
	    }
	public boolean isAlertDisplayed() {
		return alertisAvilable.isDisplayed();
	}
}
