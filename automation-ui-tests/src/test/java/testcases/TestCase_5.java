package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base;

import config.ConfigReader;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import pages.HomePage;
import pages.SignUpPage;

public class TestCase_5 extends Base {
	
	@Test
	public void verifyRegisterUserWithExistingEmail() {
		
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		homepage.signUpClick();
		
		SignUpPage signuppage = new SignUpPage(driver);
		Assert.assertTrue(signuppage.isDisplayedSignUpPage(), ConfigReader.getProperty("newUserSignUpMessage"));;
		Assert.assertEquals(signuppage.getSignUpPageTitle(), ConfigReader.getProperty("signUpPageTitle"), ConfigReader.getProperty("newUserSignUpMessage"));
		signuppage.enterName(ConfigReader.getProperty("username"));
		signuppage.enterEmail(ConfigReader.getProperty("email"));
		signuppage.clickSignUpbtn();
		Assert.assertTrue(signuppage.checkEmailValidationMsg(), ConfigReader.getProperty("signUpPageEmailMessage"));
		
	}



}
