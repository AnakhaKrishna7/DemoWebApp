package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import retry.Retry;
import utilities.ExcelUtilities;

public class ManageNewsTest extends Base{

	@Test(description = "Check whether an admin is able to add a new 'News' on the 'ManageNews' webpage.", retryAnalyzer =Retry.class)
	public void VerifywhetherTheAdminIsAbleToAddANewNews() {
		String loginUser = ExcelUtilities.getString(1, 0, "ManageNewsPage");
		String loginPassword = ExcelUtilities.getString(1, 1, "ManageNewsPage");
		String url = ExcelUtilities.getString(1, 2, "ManageNewsPage");
		String newNews = ExcelUtilities.getString(1, 3, "ManageNewsPage");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(loginUser);
		loginpage.enterPasswordOnPasswordField(loginPassword);
		loginpage.clickOnLoginButton();
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.navigateToPage(url);
		manageNews.clickTheNewButtonToCreate();
		manageNews.enterNewNews(newNews);
		manageNews.saveNewNews();
		manageNews.getAlertMessage();
		manageNews.isCreateSucessAlertDisplayed();
		Assert.assertTrue(manageNews.isCreateSucessAlertDisplayed(), "New is not created, so the success alert is not displayed!");
	}
	@Test(description = "Check whether an admin is able to edit the 'News' on the 'ManageNews' webpage.")
	public void VerifywhetherTheAdminIsAbleToEditTheNews() {
		String loginUser = ExcelUtilities.getString(1, 0, "ManageNewsPage");
		String loginPassword = ExcelUtilities.getString(1, 1, "ManageNewsPage");
		String url = ExcelUtilities.getString(1, 2, "ManageNewsPage");
		String updatedNews = ExcelUtilities.getString(1, 4, "ManageNewsPage");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(loginUser);
		loginpage.enterPasswordOnPasswordField(loginPassword);
		loginpage.clickOnLoginButton();
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.navigateToPage(url);
		manageNews.clickTheEditIconToUpdate();
		manageNews.clearTheNewsField();
		manageNews.enterTheUpdatedNews(updatedNews);
		manageNews.clickTheUpdateButton();
		manageNews.getAlerUpdatetMessage();
		Assert.assertTrue(manageNews.isCreateSucessAlertDisplayed(), "New is not Updated, so the success alert is not displayed!");
	}
	
	@Test(description = "Check whether an admin is able to delete the 'News' from the 'ManageNews' webpage.")
	public void VerifywhetherTheAdminIsAbleToDeleteTheNews() {
		String loginUser = ExcelUtilities.getString(1, 0, "ManageNewsPage");
		String loginPassword = ExcelUtilities.getString(1, 1, "ManageNewsPage");
		String url = ExcelUtilities.getString(1, 2, "ManageNewsPage");
		LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(loginUser);
		loginpage.enterPasswordOnPasswordField(loginPassword);
		loginpage.clickOnLoginButton();
		ManageNewsPage manageNews = new ManageNewsPage(driver);
		manageNews.navigateToPage(url);
		manageNews.clickOnTheDeleteButton();
        driver.switchTo().alert().accept();
        manageNews.getAlerDeleteMessage();
        String actualAlertMessage = manageNews.getAlerDeleteMessage();
        System.out.println(actualAlertMessage);
        Assert.assertTrue(manageNews.isCreateSucessAlertDisplayed(),"Can't able to delete the user");
	
	}
}
