package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PageUtility;

public class AdminUserPage {
	
	
	public WebDriver driver;
	public AdminUserPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement CreateNewAdminButton;
	@FindBy(xpath = "//input[@id='username']") WebElement UserNameField;
	@FindBy(xpath = "//input[@id='password']") WebElement PasswordField;
	@FindBy(xpath = "//select[@id='user_type']") WebElement UserTypeFieldClick;
	@FindBy(xpath = "//div[@class='card-footer center']//child::button[@class='btn btn-block-sm btn-danger']") WebElement SaveTheNewAdmin;
	@FindBy(xpath = " //div[@class='row-sm-12']//child::div[@class='alert alert-success alert-dismissible']") WebElement AlertMessage;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchButtonBox;
	@FindBy(xpath = "//input[@id='un']") WebElement searchBox;
	@FindBy(xpath = "//button[@name='Search']") WebElement searchButtonResultClick;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']") WebElement searchResultsTable;
    
    @FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]") WebElement clickTheTopOfTheEditButton;
    @FindBy(xpath = "//input[@id='username']") WebElement clearTheUserName;
    @FindBy(xpath = "//input[@id='username']") WebElement UpdatedUserName;
    @FindBy(xpath = "//button[@name='Update']") WebElement clickupdateButton;
    @FindBy(xpath = " //div[@class='row-sm-12']//child::div[@class='alert alert-success alert-dismissible']") WebElement AlertUpdateSuccessMessage;
	
    @FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]") WebElement clickTheDeleteButton;
    @FindBy(xpath = "//div[@class='row-sm-12']//child::div[@class='alert alert-success alert-dismissible']") WebElement AlertDeleteSucessMessage;
    
	public void navigateToPage(String url) {
		driver.navigate().to(url);
	}
	public void clickOnCreateNewAdminButton() {
		CreateNewAdminButton.click();
	}
	
	public void enterUserName(String userName) {
		UserNameField.sendKeys(userName);
	}
	
	public void enterPassword(String Password) {
		PasswordField.sendKeys(Password);
	}
	
	public void selectUserTypeFromDropDown(int index) {
		PageUtility utility = new PageUtility();
		utility.selectCategoryTypeFromDropDownUsingIndex(UserTypeFieldClick, index);
	
	}
	public void saveTheAdmin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(SaveTheNewAdmin));
		SaveTheNewAdmin.click();
	}
	
	public String getAlertMessage() {
        return AlertMessage.getText();
    }
	public void searchButtonForTheSearchBox() {
		searchButtonBox.click();
    }
	
	public void searchAdminNameOnTheSearchBox(String adminName) {
		searchBox.sendKeys(adminName);
    }
	public void clickTheSearchAdminNameOnTheSearchBox() {
		searchButtonResultClick.click();
    }

    public boolean isSearchResultDisplayed() {
    	return searchResultsTable.isDisplayed();
     }
    
    public void clickOnTheEditButton() {
    	clickTheTopOfTheEditButton.click();
    }
    public void clearTheUserNameField() {
    	clearTheUserName.clear();
    }
    public void enterTheNewUserName(String userName) {
    	UpdatedUserName.sendKeys(userName);
    }
    public void clickTheUpdateButton() {
    	clickupdateButton.click();
    }
    public String getAlerUpdatetMessage() {
        return AlertUpdateSuccessMessage.getText();
    }
    
    public void clickOnTheDeleteButton() {
    	clickTheDeleteButton.click();
    }

    public String getAlerDeleteMessage() {
        return AlertDeleteSucessMessage.getText();
    }
}
