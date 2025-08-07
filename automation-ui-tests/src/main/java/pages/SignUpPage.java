package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	public WebDriver driver;
	
	//--------- LOCATORS------------------------------------------
	
	@FindBy(xpath = "//h2[text()='New User Signup!']")
	private WebElement signUpPageCheck;
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement loginPageCheck;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement enterName;
	
	@FindBy(xpath = "(//input[@name='email'])[last()]")
	private WebElement enterEmail;
	
	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement clickSignUpBtn;
	
	@FindBy(xpath = "//p[text()='Email Address already exist!']")
	private WebElement checkEmailMsg;
	
	//--------- CONSTRUCTOR----------------------------
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//--------- METHODS / ACTIONS ----------------------------

	public boolean isDisplayedSignUpPage() {
		 return signUpPageCheck.isDisplayed();
	}
	
	public boolean isDisplayedLoginPage() {
		 return loginPageCheck.isDisplayed();
		 
	}
	
	public String getSignUpPageTitle() {
		return driver.getTitle();
	}
	
	public void enterName(String name) {
		enterName.sendKeys(name);
	}
	
	public void enterEmail(String email) {
		enterEmail.sendKeys(email);
	}
	
	public void clickSignUpbtn() {
		clickSignUpBtn.click();
	}
	
	public boolean checkEmailValidationMsg() {
		 return checkEmailMsg.isDisplayed();
	}
}
