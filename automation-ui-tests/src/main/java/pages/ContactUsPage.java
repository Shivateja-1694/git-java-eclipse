package pages;

import org.apache.poi.xssf.usermodel.XSSFConditionFilterData;
import org.apache.poi.xssf.usermodel.XSSFSheetConditionalFormatting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.ConfigReader;

public class ContactUsPage {
	
	WebDriver driver;
	
	//--------- LOCATORS------------------------------------------

	@FindBy(xpath = "//h2[text()='Get In Touch']")
	private WebElement checkGetInTouchIsDisplayed;
	
	@FindBy(name = "name")
	private WebElement enterName;
	
	@FindBy(name = "email")
	private WebElement enterEmail;
	
	@FindBy(name = "subject")
	private WebElement enterSubject;
	
	@FindBy(id = "message")
	private WebElement enterMessage;
	
	@FindBy(name = "upload_file")
	private WebElement clickUploadFile;
	
	@FindBy(name = "submit")
	private WebElement clickSubmitBtn;
	
	@FindBy(xpath = "(//div[text()='Success! Your details have been submitted successfully.'])[position()<last()]")
	private WebElement checkSuccessMsg;
	
	@FindBy(xpath = "//span[text()=' Home']")
	private WebElement clickHomePage;
	
	//--------- CONSTRUCTOR----------------------------

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//--------- METHODS / ACTIONS ----------------------------

	public boolean checkGetInTouchMsg() {
		return checkGetInTouchIsDisplayed.isDisplayed();
	}
	
	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void enterContactDetails(String name, String email, String subject, String message) {
		enterName.sendKeys(name);
		enterEmail.sendKeys(email);
		enterSubject.sendKeys(subject);
		enterMessage.sendKeys(message);
	}
	
	public void clickUploadFile(String filePath) {
		clickUploadFile.sendKeys(filePath);
	}
	
	public void clickSubmitBtn() {
		clickSubmitBtn.click();
	}
	
	public void checkSuccessMsg() {
		checkSuccessMsg.isDisplayed();
	}
	
	public void clickHomePageBtn() {
		clickHomePage.click();
	}
	


}
