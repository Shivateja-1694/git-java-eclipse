package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import config.ConfigReader;

public class AccountInformationPage {

	public WebDriver driver;
	
	//--------- LOCATORS------------------------------------------
	
	@FindBy(xpath = "//b[text()='Enter Account Information']")
	private WebElement accInfoMsgCheck;
	
	@FindBy(id = "id_gender1")
	private WebElement clickTitle;
	
	@FindBy(id = "password")
	private WebElement enterPassword;
	
	@FindBy(id = "days")
	private WebElement chooseDayDropdown;
	
	@FindBy(id = "months")
	private WebElement chooseMonthDropdown;
	
	@FindBy(id = "years")
	private WebElement chooseYearDropdown;
	
	@FindBy(xpath = "//div[@id='uniform-newsletter']//span//input[@id='newsletter']")
	private WebElement clickNewsLetterCheckBox;
	
	@FindBy(xpath = "//div[@id='uniform-optin']//span//input[@id='optin']")
	private WebElement clickSpecialOffersCheckBox;
	
	@FindBy(id = "first_name")
	private WebElement enterFirstName;
	
	@FindBy(id = "last_name")
	private WebElement enterLastName;
	
	@FindBy(id = "company")
	private WebElement enterCompany;
	
	@FindBy(id = "address1")
	private WebElement enterAddress;
	
	@FindBy(id = "address2")
	private WebElement enterAddress2;
	
	@FindBy(id = "country")
	private WebElement chooseCountry;
	
	@FindBy(id = "state")
	private WebElement enterState;
	
	@FindBy(id = "city")
	private WebElement enterCity;
	
	@FindBy(id = "zipcode")
	private WebElement enterZipCode;
	
	@FindBy(id = "mobile_number")
	private WebElement enterMobileNumber;
	
	@FindBy(xpath = "//button[text()='Create Account']")
	private WebElement clickCreateAccBtn;
	
	@FindBy(xpath = "//b[text()='Account Created!']")
	private WebElement accCreatedMsgCheck;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement clickContinueBtn;
	
	@FindBy(xpath = "//a[text()=' Delete Account']")
	private WebElement clickDeleteBtn;
	
	@FindBy(xpath = "//b[text()='Account Deleted!']")
	private WebElement checkAccDelSuccMsg;
	
	@FindBy(xpath = "//a[text()='Continue']")
	private WebElement clickContinueBtn2;
	

	//--------- CONSTRUCTOR----------------------------
	
	public AccountInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//--------- METHODS / ACTIONS ----------------------------

	public boolean isDisplayedAccInfoMsg() {
		return accInfoMsgCheck.isDisplayed();
	}
	
	public String getAccInfoTitle() {
		return driver.getTitle();
	}
	
	public void clickTitle() {
		if(!clickTitle.isSelected())
		clickTitle.click();
	}
	
	public void enterPassword(String password) {
		enterPassword.sendKeys(password);
	}
	
	public void selectDOB(String day, String month, String year) {
		 Select selectDay = new Select(chooseDayDropdown);
		 selectDay.selectByValue(day);
		 
		 Select selectMonth = new Select(chooseMonthDropdown);
		 selectMonth.selectByValue(month);
		 
		 Select selectYear = new Select(chooseYearDropdown);
		 selectYear.selectByValue(year);
	}
	
	public void clickNewsLetterCheckBox() {
		if(!clickNewsLetterCheckBox.isSelected()) 
			clickNewsLetterCheckBox.click();
	}
	
	public void clickSpecialOffersCheckBox() {
		if(!clickSpecialOffersCheckBox.isSelected()) 
			clickSpecialOffersCheckBox.click();
	}
	
	public void enterAddressInformation(String fn, String ln, String comp, String add,  String add2, String cntry, String state, String city,String zipcode, String mobile) {
	    enterFirstName.sendKeys(fn);
	    enterLastName.sendKeys(ln);
	    enterCompany.sendKeys(comp);
	    enterAddress.sendKeys(add);
	    enterAddress2.sendKeys(add2);

	    Select country = new Select(chooseCountry);
	    country.selectByValue(cntry);
	    
	    enterState.sendKeys(state);
	    enterCity.sendKeys(city);
	    enterZipCode.sendKeys(zipcode);
	    enterMobileNumber.sendKeys(mobile);
	}
	
	public void clickCreateAccBtn() {
		clickCreateAccBtn.click();
	}
	
	public boolean accCreatedMsgDisplay() {
		return accCreatedMsgCheck.isDisplayed();
	}
	
	public void clickContinueBtn() {
		clickContinueBtn.click();
	}
	
	public String getLoggedInUserText() {
		String username = ConfigReader.getProperty("username");
	    String dynamicXPath = "//a[contains(text(), 'Logged in as') and b[contains(text(), '"+username+"')]]";
	    return driver.findElement(By.xpath(dynamicXPath)).getText().trim();
	}
	
	public void clickDeletebtn() {
		clickDeleteBtn.click();
	}
	
	public boolean checkAccDelSuccMsg() {
		return checkAccDelSuccMsg.isDisplayed();
	}
	
	public void clickContinueBtn2() {
		clickContinueBtn2.click();
	}
}

