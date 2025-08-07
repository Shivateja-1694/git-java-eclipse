package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.HomePage;

public class TestCase_7 extends Base {
	
	@Test
	public void verifyTestCasePage() {
		
		HomePage homepage = new HomePage(driver);
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(homepage.getClickTestCasesBtn())).click();

		Assert.assertTrue(homepage.checkTestCaseTitle(), ConfigReader.getProperty("testCasesPageTitleMsg"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("testCasesPageTitle"), ConfigReader.getProperty("testCasesMsgVal"));
		
	}
}
