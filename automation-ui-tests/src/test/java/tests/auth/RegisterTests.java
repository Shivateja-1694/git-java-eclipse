package tests.auth;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.AccountInformationPage;
import pages.HomePage;
import pages.SignUpPage;
import utils.Utility;

public class RegisterTests extends Base {

	@Test
	public void registerUser() {

		HomePage homepage = new HomePage(driver);
		
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		homepage.signUpClick();
		
		SignUpPage signuppage = new SignUpPage(driver);
		
		Assert.assertTrue(signuppage.isDisplayedSignUpPage(), ConfigReader.getProperty("newUserSignUpMessage"));
		Assert.assertEquals(signuppage.getSignUpPageTitle(), ConfigReader.getProperty("signUpPageTitle"), ConfigReader.getProperty("newUserSignUpMessage"));
		signuppage.enterName(ConfigReader.getProperty("username"));
		signuppage.enterEmail(Utility.randomNumbers());
		signuppage.clickSignUpbtn();
		
		AccountInformationPage accinfo = new AccountInformationPage(driver);
		
		Assert.assertTrue(accinfo.isDisplayedAccInfoMsg(), ConfigReader.getProperty("accInfoMessage"));
		Assert.assertEquals(accinfo.getAccInfoTitle(), ConfigReader.getProperty("accInfoTitle"), ConfigReader.getProperty("accInfoMessage"));
		accinfo.clickTitle();
		accinfo.enterPassword(ConfigReader.getProperty("password"));
		accinfo.selectDOB(ConfigReader.getProperty("dobDay"), ConfigReader.getProperty("dobMonth"), ConfigReader.getProperty("dobYear"));
		accinfo.clickNewsLetterCheckBox();
		accinfo.clickSpecialOffersCheckBox();
		accinfo.enterAddressInformation(ConfigReader.getProperty("firstName"), ConfigReader.getProperty("lastName"), ConfigReader.getProperty("company"), ConfigReader.getProperty("address1"), ConfigReader.getProperty("address2"), ConfigReader.getProperty("country"), ConfigReader.getProperty("state"), ConfigReader.getProperty("city"), ConfigReader.getProperty("zipcode"), ConfigReader.getProperty("mobileNumber"));
		accinfo.clickCreateAccBtn();
		accinfo.accCreatedMsgDisplay();
		accinfo.clickContinueBtn();
		String expected = "Logged in as " + ConfigReader.getProperty("username");
		Assert.assertEquals(accinfo.getLoggedInUserText(), expected, ConfigReader.getProperty("loginUserNameMsg"));
		accinfo.clickDeletebtn();
		Assert.assertTrue(accinfo.checkAccDelSuccMsg(), ConfigReader.getProperty("accDelSuccMess"));
		accinfo.clickContinueBtn2();
	
	}

}
