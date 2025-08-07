package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.ContactUsPage;
import pages.HomePage;

public class TestCase_6 extends Base {
	
	@Test
	public void verifyRegisterUserWithExistingEmail() {
		
		HomePage homepage = new HomePage(driver);
		
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		homepage.clickContactUsBtn();
		
		ContactUsPage contactus = new ContactUsPage(driver);
		
		Assert.assertTrue(contactus.checkGetInTouchMsg(), ConfigReader.getProperty("contactUsMsg"));
		Assert.assertEquals(contactus.getContactUsPageTitle(), ConfigReader.getProperty("contactUsPageTitle"), ConfigReader.getProperty("contactUsPageTitleMsg"));
		contactus.enterContactDetails(ConfigReader.getProperty("name"), ConfigReader.getProperty("email"), ConfigReader.getProperty("subject"), ConfigReader.getProperty("message"));
		contactus.clickUploadFile(ConfigReader.getProperty("fileUploadPath"));
		contactus.clickSubmitBtn();
		driver.switchTo().alert().accept();
		Assert.assertTrue(contactus.checkGetInTouchMsg(), ConfigReader.getProperty("contactSuccessMsg"));
		contactus.clickHomePageBtn();
		
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		
		
	}



}
