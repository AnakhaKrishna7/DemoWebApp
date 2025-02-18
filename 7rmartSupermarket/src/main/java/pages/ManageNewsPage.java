package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;
	public ManageNewsPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement CreateNewButton;
	@FindBy(xpath = "//textarea[@id='news']") WebElement EnterNewInformation;
	@FindBy(xpath = "//button[@name='create']") WebElement SaveTheNews;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement AlertMessage;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement NewsSuccessfullyCreated;
	
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]") WebElement clickTheEditIcon;
	@FindBy(xpath = "//textarea[@id='news']") WebElement clearTheNews;
    @FindBy(xpath = "//textarea[@id='news']") WebElement UpdatedTheNews;
    @FindBy(xpath = "//button[@name='update']") WebElement clickupdateButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement AlertUpdateSuccessMessage;
    
    @FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]") WebElement clickTheDeleteButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement AlertDeleteSucessMessage;
	
	public void navigateToPage(String url) {
		driver.navigate().to(url);
	}
	public void clickTheNewButtonToCreate() {
		CreateNewButton.click();
	}
	public void enterNewNews(String NewNews) {
		EnterNewInformation.sendKeys(NewNews);
	}
	public void saveNewNews() {
		SaveTheNews.click();
	}
	public String getAlertMessage() {
        return AlertMessage.getText();
    }
	  public boolean isCreateSucessAlertDisplayed() {
	    	return NewsSuccessfullyCreated.isDisplayed();
	}
	  public void clickTheEditIconToUpdate() {
		  clickTheEditIcon.click();
		}
	  public void clearTheNewsField() {
		  clearTheNews.clear();
	    }
	    public void enterTheUpdatedNews(String updatedNews) {
	    	UpdatedTheNews.sendKeys(updatedNews);
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
