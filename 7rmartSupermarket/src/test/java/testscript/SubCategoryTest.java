package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtilities;

public class SubCategoryTest extends Base{
	@Test(description = "Check whether an admin is able to add a sub category on the 'Sub Category' webpage.")
	public void verifyWheatherUserCanCreateNewSubCategory()
		{
		String userName = ExcelUtilities.getString(1, 0, "SubCategoryPage");
		String Password = ExcelUtilities.getString(1, 1, "SubCategoryPage");
		String expectedAlertMessageForUserCreate = ExcelUtilities.getString(1, 2, "SubCategoryPage");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnLoginButton();
		SubCategoryPage subcategorypage = new SubCategoryPage(driver);
		subcategorypage.selctionOfSubCategoryPage();
		subcategorypage.selectionfSubCategoryCreateButton();
		subcategorypage.categorySelectedFromDropDown();
		subcategorypage.enteringSubcategoryName();
		subcategorypage.imageuploadingForSubCategoryCreate();
		subcategorypage.buttonClickForCreatingSubCategory();
		String actualAlertMessageForUserCreate=subcategorypage.alertdisplay().trim().replaceAll("\\P{Print}", "").replaceAll("\\s+", " ");
		assertEquals(actualAlertMessageForUserCreate,expectedAlertMessageForUserCreate,"SubCategory is not created.");
		}

}


