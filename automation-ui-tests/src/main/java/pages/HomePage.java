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
	
	@FindBy(xpath = "//a[text()=' Contact us']")
	private WebElement clickContactUs;
	
	@FindBy(xpath = "(//button[text()='Test Cases'])[last()]")
	private WebElement clickTestCasesBtn;
	
	@FindBy(xpath = "//b[text()='Test Cases']")
	private WebElement checkTestCaseMsg;
	
	
	
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
	
	public void clickContactUsBtn() {
		clickContactUs.click();
	}
	
	public WebElement getClickTestCasesBtn() {
	    return clickTestCasesBtn;
	}
	
	public void clickTestCasesBtn() {
		clickTestCasesBtn.click();
	}
	
	public boolean checkTestCaseTitle() {
		return checkTestCaseMsg.isDisplayed();
	}
	
	public String getTestcasesPageTitle() {
		return driver.getTitle();
	}
	

}
