package testscript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtilities;

public class LoginTest extends Base{

	@Test (priority =4, description = " Verify Dashboard is Loaded after Login with valid credentials")
	public void verifyUserLoginWithValidUserNameAndValidPassword(){
		String UserName = ExcelUtilities.getString(1, 0, "LoginPage");
		String Password = ExcelUtilities.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(UserName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnLoginButton();
		boolean tileIsAvailable = loginpage.OnDasboardTileIsAvailable();
		Assert.assertTrue(tileIsAvailable,"User should not be able redirected to the dashboard.");
	}


	@Test(priority =1, description ="Verify user is not allowed to Login with a invalid username and valid password")
	public void verifyUserLoginWithInvalidUserNameAndValidPassword() {
		
		String UserName = ExcelUtilities.getString(2, 0, "LoginPage");
        String Password = ExcelUtilities.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(UserName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnLoginButton();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,"User is easily redirected to the dashboard with an invalid username");
     }
	
	@Test(priority =2, description ="Verify user is not allowed to Login with a valid username and invalid username")
	public void verifyUserLoginWithValidUserNameAndInvalidPassword() {
		
		String UserName = ExcelUtilities.getString(1, 0, "LoginPage");
        String Password = ExcelUtilities.getString(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(UserName).enterPasswordOnPasswordField(Password).clickOnLoginButton();
		boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,"User is easily redirected to the dashboard with an invalid password.");
}
	
	@Test(priority =3, description ="Verify user is not allowed to Login with a valid username and invalid username", dataProvider = "LoginProvider")
	public void verifyUserLoginWithInvalidUserNameAndInvalidPassword(String UserName,String Password) {
		
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(UserName);
		loginpage.enterPasswordOnPasswordField(Password);
		loginpage.clickOnLoginButton();
	    boolean alert = loginpage.isAlertDisplayed();
		Assert.assertTrue(alert,"User is easily redirected to the dashboard with an invalid username and password.");
     }
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtilities.getString(2, 0, "LoginPage"), ExcelUtilities.getString(2, 1, "LoginPage") },
			{"abc","abc"},
			{"hello","hello"}

		};
}
	}
