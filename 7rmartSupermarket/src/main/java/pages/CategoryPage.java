package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constant;
import utilities.FileUploadUtitity;
import utilities.PageUtility;
import utilities.RandomUtility;

public class CategoryPage {
public WebDriver driver;
	
	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement newCategoryCreateButton;
	@FindBy(xpath ="//input[@class='form-control']")WebElement categoryLableName;
	@FindBy(xpath = "//li[@id='134-selectable']") WebElement groupSelection;
	@FindBy(xpath = "//input[@name='main_img']") WebElement fileChoose;
	@FindBy(xpath = "//label[text()='Show On Top Menu']//following-sibling::label//child::input[@value='no']") WebElement selctionofTopMenu;
	@FindBy(xpath = "//button[@type='submit']") WebElement categorySave;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement successAlertDisplay;
	
	public void navigateToPage(String url) {
		driver.navigate().to(url);
	}
	
	public void categoryCreateButtonselection()
	{
		newCategoryCreateButton.click();
	}
	
	public void enterCategoryName()
	{
		RandomUtility randomutility = new RandomUtility();
		String fakerCategoryName = randomutility.createCategoryName();
		categoryLableName.sendKeys(fakerCategoryName);
	}
	
	public void selectingTheGroupsForCategoryDisplay()
	{
		groupSelection.click();
		PageUtility pageutility = new PageUtility();
		pageutility.scrollTODown(driver);
	
	}
	
	public void fileUploadforCategoryCreate()
	{
		FileUploadUtitity fileuploadutility = new FileUploadUtitity();
		fileuploadutility.FileUploadUsingSendKeys(fileChoose, Constant.TESTIMAGEFILE);
		
	}
	
	public void selectionofCategoryDisplayinTopMenu()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.elementToBeClickable(selctionofTopMenu));
		selctionofTopMenu.click();
	}
	
	public void pageCompleteScrollingdown()
	{
		PageUtility pageutility = new PageUtility();
		pageutility.completeScrollDown(driver);
	}
	
	public void createdCategorySavingtoTheList()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOf(categorySave));
		categorySave.click();
	}
	
	public String alertDisplay() {
		String messageDisplayed = successAlertDisplay.getText();
		return messageDisplayed;
	}
	
}
