package com.mindtree.CucumberFramework.pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;
import com.mindtree.CucumberFramework.execptions.WebDriverExceptions;
import com.mindtree.CucumberFramework.utils.ReadConfigFile;



public class LoginPageCommon extends BasePage {
	Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports extent;
    ExtentTest test;
    
	public static ExtentTest logger;
	
	ReadConfigFile file = new ReadConfigFile();
	
	
	public LoginPageCommon() {
		PageFactory.initElements(driver(), this);
		
	}
	
	
	private String emailID ="//XCUIElementTypeTextField[@name=\"Email Textfield\"]";
	private String continueButton="//XCUIElementTypeStaticText[@name=\"Continue\"]";
	private String pwd = "//XCUIElementTypeSecureTextField[@name=\"Password Textfield\"]";
	private String pwd3 =  "//XCUIElementTypeTextField[@name=\"Password Textfield\"]";
	private String pwd2= "//XCUIElementTypeTextField[@name=\"Email Textfield\" and @enabled=\"true\"]";
	private String continueButton2 ="(//XCUIElementTypeStaticText[@name=\"Continue\"])[2]";
	//XCUIElementTypeButton[@name=\"Continue\" and @enabled=\"true\"]
	
	


	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Next\"]")
	public WebElement LoginButton;
	
	@FindBy(xpath =  "//*[@name=\"Next\"]")
	private WebElement nextButton;
	
	
	//@FindBy(name =  "Next")
	
	private String allow1 = "//XCUIElementTypeButton[@name=\"Allow\"]";
	//@FindBy(xpath =  "//*[@name=\"Next\"]")
	private String nextButton1 = "//*[@name=\"Next\"]";
	private String SignIn = "Home Rewards Card";
	private String pickupButton = "//*[@name=\"Pick-Up\"]";
	
	
	private String findAShackButton = "//XCUIElementTypeButton[@name=\"FindShackCTA\" and @visible=\"true\"]";
	private String findAShackButtonNotNow = "//XCUIElementTypeButton[@name=\"NotNowCTA\"]";
	
	private String allowWhileUsingApp = "Allow While Using App";
	private String searchInFindShack = "//XCUIElementTypeButton[@name=\"Search button\"]";
	
	
	private String addressInputText = "//*[@name=\"Textfield\"]";
	private String addressInputText2 = "Textfield";
	By address = By.xpath("//*[@name=\"Textfield\"]");
	private String startOrder = "//*[@name=\"Start Order\"]";
	private String yepThatsCorrect = "//*[@name=\"Yep, That’s Correct!\"]";
	private String indoorPickup = "//*[@name=\"Indoor Pick-Up\"]";
	private String bugerMenu = "//*[@name=\"Category Button - Burgers\"]"; 
	
	
	private String BurgerHeading = "//XCUIElementTypeOther[@name=\"Burgers, No hormones or antibiotics ever, our 100% Angus beef is humanely raised and grazed in the USA\"]";
	private String itemName = "(//XCUIElementTypeStaticText[@name=\"Name\"])[1]";
	private String priceInBurgerCategory = "(//XCUIElementTypeStaticText[@name=\"Price\"])[1]";
	private String itemCalories = "(//XCUIElementTypeStaticText[@name=\"Calories\"])[1]";
	
	private String QuantityNumber = "(//XCUIElementTypeStaticText[@name=\"Quantity Label\"])[2]";
	private String addtoBag = "(//XCUIElementTypeStaticText[@name=\"Quantity Label\"])[2]";
	
	public void ClickOnAllowInPopup() throws Exception {
		clickUsingXPath(allow1);
        System.out.println("clicked on allow button");
        Reporter.addStepLog("successfully tapped on allow button");
    }
	
	public void ClickOnNextButtonInAdvertizement() throws Exception {
		Thread.sleep(5000);
		try{
			clickUsingXPath(nextButton1);
			System.out.println("click on next");
			Reporter.addStepLog("successfully tapped on next button");
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public void ClickOnNextButtonInIfAdvertizementIsDisplayed() throws Exception {
		waitForElementClickableByID(addressInputText2, 15);
		try{
			if(nextButton1.contains("Next")){
				clickUsingXPath(nextButton1);
				System.out.println("click on next");
				Reporter.addStepLog("successfully tapped on next button");
				Thread.sleep(6000);
				driver().switchTo().alert().accept();
				System.out.println("click on second allow");
				Reporter.addStepLog("successfully tapped on second allow button");
				Thread.sleep(4000);
			}else{
				clickUsingXPath(pickupButton);
				System.out.println("clicked on Pick-up");
				Reporter.addStepLog("successfully tapped on pick-up button");
			}
		}catch(Exception e){
			throw e;
		}
		
	}
	public void ClickOnNextButton() throws Exception {
		Thread.sleep(8000);
		if(driver().findElement(By.xpath("//*[@name=\"Next\"]")).isDisplayed()){
			try{
				clickUsingXPath(nextButton1);
				System.out.println("click on next");
				Reporter.addStepLog("successfully tapped on next button");
				Thread.sleep(6000);
				driver().switchTo().alert().accept();
				System.out.println("click on second allow");
				Reporter.addStepLog("successfully tapped on second allow button");
				Thread.sleep(3000);
				
				
			}catch(Exception e){
				throw e;
			}
		}else{
			System.out.println("next button is not displayed");
			Reporter.addStepLog("next button is not displayed");
			System.out.println("second allow not displayed");
			Reporter.addStepLog("second allow not displayed");
		}
		
	}
	public void tapOnSignInHomePage() throws Exception {
		Thread.sleep(4000);
		try{
			clickUsingID(SignIn);
			System.out.println("tap on SignIn in home page");
			Reporter.addStepLog("tap on SignIn in home page");
			Thread.sleep(6000);
			
		}catch(Exception e){
			throw e;
		}
		
	}
	
	public void clickOnPickup() throws Exception {
		clickUsingXPath(pickupButton);
		//driver().findElementByName("Pick-Up").click();
		//logger.log(LogStatus.INFO, "tap on pickup");
		System.out.println("clicked on Pick-up");
		Reporter.addStepLog("tapped on Pick-up");
	}
	
	public void clickOnPickupButtonInHomeScreen() throws Exception {
		Thread.sleep(3000);
		driver().switchTo().alert().accept();
		System.out.println("click on second allow");
		Reporter.addStepLog("click on second allow");
		Thread.sleep(2000);
		clickUsingXPath(pickupButton);
		//driver().findElementByName("Pick-Up").click();
		//logger.log(LogStatus.INFO, "tap on pickup");
		System.out.println("clicked on Pick-up");
		Reporter.addStepLog("tapped on Pick-up");
	}
	
	public void clickOnFindShack() throws Exception {
		clickUsingXPath(findAShackButton);
		Reporter.addStepLog("tapped on Find a Shack button");
		System.out.println("clicked on find a shack button");
	}
	
	public void clickOnFindShackOrNotNowButton() throws Exception {
		WebElement e = driver().findElementByXPath(findAShackButtonNotNow);
		if(e.isDisplayed()){
			clickUsingXPath(findAShackButtonNotNow);
			Reporter.addStepLog("tapped on not now button");
			System.out.println("clicked on not now button");
		}else{
			Reporter.addStepLog("not now or find a shack button not displayed");
			System.out.println("not now or find a shack button not displayed");
		}
		
	}

	public void popupPermissionAllowWhileUsingApp() throws Exception{
		Thread.sleep(12000);
		clickUsingName(allowWhileUsingApp);
		Reporter.addStepLog("Allow while using App permission provided");
		System.out.println("allow permission popup Allow While Using App");
		Thread.sleep(5000);
		clickUsingXPath(searchInFindShack);
		
	}
	
	public void enterTheNearestShackOrPostalCodeInTextField() throws Exception{
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(15000);
		waitForElementClickableByID(addressInputText2, 50);
		System.out.println("clicked on address text using ID");
		sendKeysUsingName(addressInputText2, p.getProperty("restaurantAddressFiled1"));
		Reporter.addStepLog("the nearest Shack is - " +p.getProperty("restaurantAddressFiled1"));
		//driver().findElementByXPath("//*[@name=\"Textfield\"]").sendKeys("Demo Vendor");
		Thread.sleep(1000);
		driver().findElementByXPath("//*[@name=\"Textfield\"]").sendKeys(Keys.ENTER);
		//}else{
			
		//}
		//driver().findElementByXPath("//*[@name=\"done\"]").click();
		//logger.log(LogStatus.INFO, "enter the nearest shack Demo Vendor");
		System.out.println("enter the nearest shack "+p.getProperty("restaurantAddressFiled1"));
	}
	public void enterTheNearestShackOrPostalCodeInTextField2() throws Exception{
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(15000);
		waitForElementClickableByID(addressInputText2, 50);
		System.out.println("clicked on address text using ID");
		sendKeysUsingName(addressInputText2, p.getProperty("restaurantAddressFiled2"));
		Reporter.addStepLog("the nearest Shack is - " +p.getProperty("restaurantAddressFiled2"));
		//driver().findElementByXPath("//*[@name=\"Textfield\"]").sendKeys("Demo Vendor");
		Thread.sleep(1000);
		driver().findElementByXPath("//*[@name=\"Textfield\"]").sendKeys(Keys.ENTER);
		//}else{
			
		//}
		//driver().findElementByXPath("//*[@name=\"done\"]").click();
		//logger.log(LogStatus.INFO, "enter the nearest shack Demo Vendor");
		System.out.println("enter the nearest shack "+p.getProperty("restaurantAddressFiled1"));
	}
	public void clickOnStartOrderButtonAndTapOnYepThatsCorrect() throws Exception{
		waitForElementClickable(startOrder, 20);
		//clickUsingXPath(startOrder);
		Reporter.addStepLog("tapped on Start Order button");
		//driver().findElementByXPath("//*[@name=\"Start Order\"]").click();
		Thread.sleep(1000);
		clickUsingXPath(yepThatsCorrect); System.out.println("Yep Thats Correct");
		//driver().findElementByXPath("//*[@name=\"Yep, That’s Correct!\"]").click();
		
	}
	
	public void selectIndoorPickup() throws Exception{
		waitForElementClickable(indoorPickup, 40);
		System.out.println("clicked on Indoor Pickup");
		Reporter.addStepLog("indoor pickup got selectd");
	}
	
	
	/////login function 
	
	public void loginWithValidCredentials() throws Exception{
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		
		Thread.sleep(5000);
		//clickUsingXPath(emailID);
		sendKeysUsingXpath(emailID, p.getProperty("login.username"));
		System.out.println(p.getProperty("login.username"));
		Reporter.addStepLog("email ID entered:" +p.getProperty("login.username"));
		driver().findElementByXPath("//*[@name=\"Email Textfield\"]").sendKeys(Keys.ENTER);
		clickUsingXPath(continueButton);
		Reporter.addStepLog("tapped on continue button after entering emailId");
		Thread.sleep(6000);
		
		clickUsingXPath("//XCUIElementTypeButton[@name=\"Show password\"]");
		System.out.println("clicked on show password");
		
		clickUsingXPath("//XCUIElementTypeTextField[@name=\"Password Textfield\"]");
		System.out.println("clicked inside password field");
		
		
		//clickUsingXPath(pwd2);
		//driver().findElementById("//XCUIElementTypeApplication[@name=\"Project Finley Staging\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[6]/XCUIElementTypeTextField").sendKeys("Madhugiri@ka64");
		//sendKeysUsingXpath(pwd2, "Madhugiri@ka64");
		sendKeysUsingXpath("//XCUIElementTypeTextField[@name=\"Password Textfield\"]", "Madhugiri@ka64");
		System.out.println("Madhugiri@ka64");
		
		//Reporter.addStepLog("password entered:" +p.getProperty("login.password"));
		//driver().findElementByXPath("//*[@name=\"Password Textfield\"]").sendKeys(Keys.ENTER);
		//driver().findElementByXPath("pwd").sendKeys(Keys.ENTER);
		clickUsingXPath(continueButton2);
		System.out.println(p.getProperty("tapped on continue button after entering password"));
		Reporter.addStepLog("tapped on continue button after entering password");
		Thread.sleep(25000);
	}
	
	public void loginWithValidCredentials2() throws Exception{
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(5000);
		sendKeysUsingXpath(emailID, p.getProperty("login.username"));
		System.out.println(p.getProperty("login.username"));
		Reporter.addStepLog("email ID entered:" +p.getProperty("login.username2"));
		driver().findElementByXPath("//*[@name=\"Email Textfield\"]").sendKeys(Keys.ENTER);
		clickUsingXPath(continueButton);
		Reporter.addStepLog("tapped on continue button after entering emailId");
		Thread.sleep(6000);
		clickUsingXPath("//XCUIElementTypeButton[@name=\"Show password\"]");
		System.out.println("clicked on show password");
		
		clickUsingXPath("//XCUIElementTypeTextField[@name=\"Password Textfield\"]");
		System.out.println("clicked inside password field");
		
		
		sendKeysUsingXpath("//XCUIElementTypeTextField[@name=\"Password Textfield\"]", p.getProperty("login.password2"));
		System.out.println(p.getProperty("login.password2"));
		
		clickUsingXPath(continueButton2);
		System.out.println(p.getProperty("tapped on continue button after entering password"));
		Reporter.addStepLog("tapped on continue button after entering password");
		Thread.sleep(25000);
	}
	
	
	
	
	
}
