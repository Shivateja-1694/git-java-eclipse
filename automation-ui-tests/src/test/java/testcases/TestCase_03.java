package testcases;

import org.testng.Assert;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.HomePage;
import pages.LoginPage;

public class TestCase_03 extends Base {

	public void verifyLoginWithIncorrectEmailAndPassword() {
		
		HomePage homepage = new HomePage(driver);
	
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		homepage.signUpClick();
		
		LoginPage loginpage = new LoginPage(driver);
		
		Assert.assertTrue(loginpage.checkLoginFieldMessage(), ConfigReader.getProperty("loginPageText"));
		Assert.assertEquals(loginpage.getLoginPageTitle(), ConfigReader.getProperty("signUpPageTitle"), ConfigReader.getProperty("loginPageText"));
		loginpage.enterEmailID(ConfigReader.getProperty("incorrectEmail"));
		loginpage.enterPassword(ConfigReader.getProperty("incorrectPass"));
		loginpage.clickLoginBtn();
		Assert.assertEquals(loginpage.getInLineMessageText(), ConfigReader.getProperty("loginInlineMessage"), ConfigReader.getProperty("loginInlineMsgPrint"));
		
	}

}
