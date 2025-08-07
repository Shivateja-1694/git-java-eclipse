package testcases;

import org.testng.Assert;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.AccountInformationPage;
import pages.HomePage;
import pages.LoginPage;

public class TestCase_02 extends Base {
	
	public void verifyLoginUserWithCorrectEmailAndPassword() {
		
		HomePage homepage = new HomePage(driver);
		
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		homepage.signUpClick();
		
		LoginPage loginpage = new LoginPage(driver);
		
		Assert.assertTrue(loginpage.checkLoginFieldMessage(), ConfigReader.getProperty("loginPageText"));
		Assert.assertEquals(loginpage.getLoginPageTitle(), ConfigReader.getProperty("signUpPageTitle"), ConfigReader.getProperty("loginMessage"));
		loginpage.enterEmailID(ConfigReader.getProperty("email"));
		loginpage.enterPassword(ConfigReader.getProperty("pass"));
		loginpage.clickLoginBtn();

		AccountInformationPage accInfo = new AccountInformationPage(driver);

		String expected = "Logged in as " + ConfigReader.getProperty("username");
		Assert.assertEquals(accInfo.getLoggedInUserText(), expected, ConfigReader.getProperty("loginUserNameMsg"));
		accInfo.clickDeletebtn();
		Assert.assertTrue(accInfo.checkAccDelSuccMsg(), ConfigReader.getProperty("accDelSuccMess"));
	}
	

}
