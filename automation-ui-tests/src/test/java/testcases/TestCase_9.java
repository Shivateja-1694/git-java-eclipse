package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.Base;

import config.ConfigReader;
import pages.HomePage;
import pages.ProductsPage;

public class TestCase_9 extends Base {
	
	@Test
	public void verifySearchProduct() {
		
	HomePage homepage = new HomePage(driver);
	Assert.assertTrue(homepage.isDisplayedHomePage(), ConfigReader.getProperty("homePageMessage"));
	Assert.assertEquals(homepage.getHomePageTitle(), ConfigReader.getProperty("homePageTitle"), ConfigReader.getProperty("homePageMessage"));
	
	ProductsPage productsPage = new ProductsPage(driver);
	productsPage.clickProductsBtn();
	Assert.assertTrue(productsPage.checkAllProducts(), ConfigReader.getProperty("allProductsMsg"));
	Assert.assertEquals(productsPage.getProductsPageTitle(), ConfigReader.getProperty("productsPageTitle"), ConfigReader.getProperty("productsPageMsg"));
	productsPage.clickSearchBar(ConfigReader.getProperty("productName"));
	productsPage.clickSearchIcon();
	Assert.assertTrue(productsPage.isSearchedProductVisible(), ConfigReader.getProperty("productSearchMsg"));
	Assert.assertTrue(productsPage.allProductsVisible(), ConfigReader.getProperty("searchedProductsMsg"));
	
	driver.quit();
	
	}
	
}
