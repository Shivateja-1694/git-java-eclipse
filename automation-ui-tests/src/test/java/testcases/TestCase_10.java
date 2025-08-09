package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.HomePage;

public class TestCase_10 extends Base {
	
	@Test
	public void verifySubscriptionInHomepage() {
		
	HomePage homepage = new HomePage(driver);
	Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
	Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
	Assert.assertTrue(homepage.isSubscriptionVisible(), ConfigReader.getProperty("homePageSubscription"));
	homepage.enterEmailID(ConfigReader.getProperty("email"));
	homepage.clickArrowBtn();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	boolean isVisible = wait.until(ExpectedConditions.visibilityOf(homepage.isSuccessMessageVisible())).isDisplayed();
	Assert.assertTrue(isVisible, "Subscribe success message is not visible");

	driver.quit();
	
	}
	
}
