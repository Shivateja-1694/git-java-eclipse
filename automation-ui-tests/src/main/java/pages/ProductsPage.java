package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	WebDriver driver;
	
	//--------- LOCATORS------------------------------------------
	
	@FindBy(xpath = "//a[text()=' Products']")
	private WebElement clickProductsBtn;

	@FindBy(xpath = "//h2[text()='All Products']")
	private WebElement checkAllProducts;
	
	@FindBy(xpath = "//div[contains(@class,'features_items')]")
	private WebElement checkProductsList;
	
	@FindBy(xpath = "(//i[contains(@class,'fa fa-plus-square')])[1]")
	private WebElement clickViewProducts;
	
	@FindBy(xpath = "//a[text()='Write Your Review']")
	private WebElement checkReviewMsg;
	
	@FindBy(xpath = "//div[contains(@class,'product-information')]//h2")
	private WebElement productName;
	
	@FindBy(xpath = "//div[contains(@class,'product-information')]//p[contains(text(),'Category:')]")
	private WebElement category;
	
	@FindBy(xpath = "//span[contains(text(),'Rs.')]")
	private WebElement price;
	
	@FindBy(xpath = "//div[contains(@class,'product-info')]/descendant::b[contains(text(),'Availability:')]")
	private WebElement availability;
	
	@FindBy(xpath = "//div[contains(@class,'product-info')]/descendant::b[contains(text(),'Condition:')]")
	private WebElement condition;
	
	@FindBy(xpath = "//div[contains(@class,'product-info')]/descendant::b[contains(text(),'Brand:')]")
	private WebElement brand;
	
	@FindBy(id = "search_product")
	private WebElement searchBar;
	
	@FindBy(id = "submit_search")
	private WebElement clickSearchIcon;
	
	@FindBy(xpath = "//h2[text()='Searched Products']")
	private WebElement searchedProduct;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']")
	private List<WebElement> productsList;
	
	//--------- CONSTRUCTOR----------------------------

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//--------- METHODS / ACTIONS ----------------------------

	public void clickProductsBtn() {
		clickProductsBtn.click();
	}
	
	public String getProductsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkAllProducts() {
		return checkAllProducts.isDisplayed();
	}
	
	public boolean checkProductListPage() {
		return checkProductsList.isDisplayed();
	}
	
	public WebElement getClickViewProducts() {
	    return clickViewProducts;
	}

	public void clickViewProducts() {
	    clickViewProducts.click();
	}
	
	public String getProductsDetailsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkReviewMsg() {
		return checkReviewMsg.isDisplayed();
	}
	
	public boolean isProductNameVisible() {
		return productName.isDisplayed();
	}
	
	public boolean isProductCategoryVisible() {
		return category.isDisplayed();
	}
	
	public boolean isProductPriceVisible() {
		return price.isDisplayed();
	}
	
	public boolean isAvailabilityVisible() {
		return availability.isDisplayed();
	}
	
	public boolean isConditionVisible() {
		return condition.isDisplayed();
	}
	
	public boolean isBrandVisible() {
		return brand.isDisplayed();
	}
	
	public void clickSearchBar(String productName) {
		//searchBar.click();
		searchBar.sendKeys(productName);
	}
	
	public void clickSearchIcon() {
		clickSearchIcon.click();
	}
	
	public boolean isSearchedProductVisible() {
		return searchedProduct.isDisplayed();
	}
	
	public boolean allProductsVisible() {
		
	    if(productsList.isEmpty()) {
	        System.out.println("No products found on the page!");
	        return false;
	    }
	    
		for(WebElement product : productsList) {
			if(!product.isDisplayed()) {
				return false;
			}
		}
		return true;
	}
	

}
