package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	//--------- LOCATORS------------------------------------------
	
	@FindBy(xpath = "//a[normalize-space(text())='Home']")
	private WebElement homePageCheck;
	
	@FindBy(xpath = "//a[normalize-space(text())='Signup / Login']")
	private WebElement signUpClick;
	
	
	
	
	//--------- CONSTRUCTOR----------------------------
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//--------- METHODS / ACTIONS ----------------------------

	public boolean isDisplayedHomePage() {
		return homePageCheck.isDisplayed();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public void signUpClick() {
		signUpClick.click();
	}
}
