package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.ConfigReader;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class LoginPage {
	
	WebDriver driver;
	
	//-------------- LOCATORS ------------------------
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	private WebElement checkLoginMsg;
	
	@FindBy(xpath = "(//input[@placeholder='Email Address'])[position()<last()]")
	private WebElement enterEmailID;
	
	@FindBy(name = "password")
	private WebElement enterPassword;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement clickLoginBtn;
	
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	private WebElement loginInLineMsg;
	
	@FindBy(xpath  = "//a[text()=' Logout']")
	private WebElement logoutBtnClick;

	//-------------- CONSTRUCTOR-----------------------
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//-------------- METHODS / ACTIONS -----------------------

	public boolean checkLoginFieldMessage() {;
		return checkLoginMsg.isDisplayed();
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterEmailID(String email) {
		enterEmailID.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		clickLoginBtn.click();
	}
	
	public String getInLineMessageText() {
		return loginInLineMsg.getText().trim();
	}
	
	public void clickLogoutBtn() {
		logoutBtnClick.click();
	}
	

}
