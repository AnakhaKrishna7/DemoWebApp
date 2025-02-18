package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtilities;
import utilities.RandomUtility;

public class AdminUserTest extends Base{
	
	@Test(description = "Check whether an admin is able to add a new admin on the 'Admin Users' webpage.")
	public void VerifywhetherTheAdminIsAbleToAddANewAdminUser() {
		
		String loginUser = ExcelUtilities.getString(1, 0, "AdminUserPage");
		String loginPassword = ExcelUtilities.getString(1, 1, "AdminUserPage");
		String expectedSuccessMessage = ExcelUtilities.getString(1, 2, "AdminUserPage");
		String url = ExcelUtilities.getString(1, 3, "AdminUserPage");
		RandomUtility randomUtility = new RandomUtility();
        String userName = randomUtility.createAUserName();
        String Password =randomUtility.createAPassword();
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(loginUser);
		loginpage.enterPasswordOnPasswordField(loginPassword);
		loginpage.clickOnLoginButton();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
		adminUserPage.navigateToPage(url);
		adminUserPage.clickOnCreateNewAdminButton();
		adminUserPage.enterUserName(userName);
		adminUserPage.enterPassword(Password);
		adminUserPage.selectUserTypeFromDropDown(2);
		adminUserPage.saveTheAdmin();
		adminUserPage.getAlertMessage();
		String actualAlertMessage = adminUserPage.getAlertMessage();
		Assert.assertTrue(actualAlertMessage.contains(expectedSuccessMessage), "Can't able to create a new Admin with the given username and password");
	}

	@Test(description = "Check whether the search results are displayed correctly on the page.")
    public void verifySearchDisplaysCorrectResults() {
		
		String loginUser = ExcelUtilities.getString(1, 0, "AdminUserPage");
		String loginPassword = ExcelUtilities.getString(1, 1, "AdminUserPage");
		String url = ExcelUtilities.getString(1, 3, "AdminUserPage");
		String searchQuery = ExcelUtilities.getString(1, 4, "AdminUserPage");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(loginUser);
		loginpage.enterPasswordOnPasswordField(loginPassword);
		loginpage.clickOnLoginButton();
        AdminUserPage adminUserPage = new AdminUserPage(driver);
        adminUserPage.navigateToPage(url);
        adminUserPage.searchButtonForTheSearchBox();
        adminUserPage.searchAdminNameOnTheSearchBox(searchQuery);
        adminUserPage.clickTheSearchAdminNameOnTheSearchBox();
        boolean displaySearchResult = adminUserPage.isSearchResultDisplayed();
        Assert.assertTrue(displaySearchResult, "Search results are not displayed correctly.");
    }
	@Test(description = "Check whether the user is able to update the username sucessfully.")
    public void verifyUseIsAbleToUpdateTheUserName() {
	
		String loginUser = ExcelUtilities.getString(1, 0, "AdminUserPage");
		String loginPassword = ExcelUtilities.getString(1, 1, "AdminUserPage");
		String url = ExcelUtilities.getString(1, 3, "AdminUserPage");
		String expectedUpdatedMessage = ExcelUtilities.getString(2, 2, "AdminUserPage");
		RandomUtility randomUtility = new RandomUtility();
        String userName = randomUtility.createAUserName();
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(loginUser);
		loginpage.enterPasswordOnPasswordField(loginPassword);
		loginpage.clickOnLoginButton();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
        adminUserPage.navigateToPage(url);
        adminUserPage.clickOnTheEditButton();
        adminUserPage.clearTheUserNameField();
        adminUserPage.enterTheNewUserName(userName);
        adminUserPage.clickTheUpdateButton();
        adminUserPage.getAlerUpdatetMessage();
        String actualAlertMessage = adminUserPage.getAlerUpdatetMessage();
		Assert.assertTrue(actualAlertMessage.contains(expectedUpdatedMessage), "Can't able to update the username");
	}
	
	@Test(description = "Check whether the user is able to delete the user sucessfully.")
    public void verifyUseIsAbleToDeleteTheUserName() {
		String loginUser = ExcelUtilities.getString(1, 0, "AdminUserPage");
		String loginPassword = ExcelUtilities.getString(1, 1, "AdminUserPage");
		String url = ExcelUtilities.getString(1, 3, "AdminUserPage");
		String expectedDeletedMessage = ExcelUtilities.getString(3, 2, "AdminUserPage");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(loginUser);
		loginpage.enterPasswordOnPasswordField(loginPassword);
		loginpage.clickOnLoginButton();
		AdminUserPage adminUserPage = new AdminUserPage(driver);
        adminUserPage.navigateToPage(url);
        adminUserPage.clickOnTheDeleteButton();
        driver.switchTo().alert().accept();
        adminUserPage.getAlerDeleteMessage();
        String actualAlertMessage = adminUserPage.getAlerDeleteMessage();
        System.out.println(actualAlertMessage);
		Assert.assertTrue(actualAlertMessage.contains(expectedDeletedMessage), "Can't able to delete the user");
	}
}
