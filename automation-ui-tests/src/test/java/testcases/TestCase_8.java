package testcases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.HomePage;
import pages.ProductsPage;

public class TestCase_8 extends Base {
	
	@Test
	public void verifyAllProductsAndProductDetailPage() {
		
		HomePage homepage = new HomePage(driver);
		
		Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
		Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
		homepage.clickProductsBtn();
		
		ProductsPage productPage = new ProductsPage(driver);
		
		Assert.assertEquals(productPage.getProductsPageTitle(), ConfigReader.getProperty("productsPageTitle"), ConfigReader.getProperty("productsPageMsg"));
		Assert.assertTrue(productPage.checkAllProducts(), ConfigReader.getProperty("allProductsMsg"));
		Assert.assertTrue(productPage.checkProductListPage(), ConfigReader.getProperty("productListMsg"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(productPage.getClickViewProducts()));
		productPage.clickViewProducts();
		Assert.assertEquals(productPage.getProductsDetailsPageTitle(), ConfigReader.getProperty("productDetailsPageTitle"), ConfigReader.getProperty("productDetailsPageMsg"));
		Assert.assertTrue(productPage.checkReviewMsg(), ConfigReader.getProperty("productReviewMsg"));
		Assert.assertTrue(productPage.isProductNameVisible(), ConfigReader.getProperty("productName"));
		Assert.assertTrue(productPage.isProductCategoryVisible(), ConfigReader.getProperty("productCategory"));
		Assert.assertTrue(productPage.isProductPriceVisible(), ConfigReader.getProperty("productPrice"));
		Assert.assertTrue(productPage.isConditionVisible(), ConfigReader.getProperty("ProductAvailability"));
		Assert.assertTrue(productPage.isAvailabilityVisible(), ConfigReader.getProperty("productCondition"));
		Assert.assertTrue(productPage.isBrandVisible(), ConfigReader.getProperty("productBrand"));
		
		driver.quit();
	}
	
}
