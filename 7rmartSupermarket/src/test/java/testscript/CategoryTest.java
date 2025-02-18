package testscript;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class CategoryTest extends Base{
	@Test (description = "Check whether an admin is able to add a category on the 'Category' webpage.")
	public void verifyWheathertheUserCanCreateACategory()
	{
		
		String userName = ExcelUtilities.getString(1, 2, "CategoryPage");
		String Password = ExcelUtilities.getString(1, 3, "CategoryPage");
		String url = ExcelUtilities.getString(1, 1, "CategoryPage");
		String expectedAlertMessageForUserCreate = ExcelUtilities.getString(1, 0, "CategoryPage");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userName);
		loginpage.enterPasswordOnPasswordField(Password); 
		loginpage.clickOnLoginButton();
		CategoryPage categorypage = new CategoryPage(driver);
		categorypage.navigateToPage(url);
		categorypage.categoryCreateButtonselection();
		categorypage.enterCategoryName();
		categorypage.selectingTheGroupsForCategoryDisplay();
		categorypage.fileUploadforCategoryCreate();
		categorypage.pageCompleteScrollingdown();
		categorypage.selectionofCategoryDisplayinTopMenu();
		categorypage.pageCompleteScrollingdown();
		categorypage.createdCategorySavingtoTheList();
		String actualAlertMessage=categorypage.alertDisplay();
		System.out.println(actualAlertMessage);
		assertEquals(actualAlertMessage.contains(expectedAlertMessageForUserCreate),"Category is not created");
	}
	

}
