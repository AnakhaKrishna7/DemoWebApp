package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtitity;
import utilities.PageUtility;
import utilities.RandomUtility;
import utilities.WaitUtility;

public class SubCategoryPage {

	
	
		public WebDriver driver;
		public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
			
		@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']//child::i[@class='fas fa-arrow-circle-right']") WebElement subCategory;
		@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']") WebElement subcategoryCreateButton;
		@FindBy(xpath = "//select[@class='form-control selectpicker']") WebElement categoryField;
		@FindBy(xpath = "//input[@id='subcategory']") WebElement SubcategoryField;
		@FindBy(xpath = "//input[@id='main_img']") WebElement fileChoose;
		@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertSuccessDisplay;
			
			public void selctionOfSubCategoryPage()
			{
				WaitUtility waitutility = new WaitUtility();
				waitutility.waitForClickUsingExplicitWait(driver, subCategory);
				subCategory.click();
			}
			
			public void selectionfSubCategoryCreateButton()
			{
				subcategoryCreateButton.click();
			}
			
			public void categorySelectedFromDropDown()
			{
				PageUtility pageutility = new PageUtility();
				pageutility.selectValueFromDropDownUsingIndex(categoryField, 4);
			}
			
			public void enteringSubcategoryName()
			{
				RandomUtility randomutility = new RandomUtility();
				String Subcategoryadding = randomutility.createsubCategoryName();
				SubcategoryField.sendKeys(Subcategoryadding);
			}
			
			public void imageuploadingForSubCategoryCreate()
			{
				FileUploadUtitity fileuploadutility = new FileUploadUtitity();
				fileuploadutility.FileUploadUsingSendKeys(fileChoose, Constant.TESTIMAGEFILE);
			}
			
			public void buttonClickForCreatingSubCategory()
			{
				WaitUtility waitutility = new WaitUtility();
				waitutility.waitForUntilElementToBeClickableUsingFluentWait(driver, saveButton);
				saveButton.click();
			}
			
			public String alertdisplay()
			{
				String alertDisplayfromScreen = alertSuccessDisplay.getText();
				System.out.println(alertDisplayfromScreen);
				return alertDisplayfromScreen;
			}
}