package com.mindtree.CucumberFramework.pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;
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



public class paymentPage_common extends BasePage {
	Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports extent;
    ExtentTest test;
    
	public static ExtentTest logger;
    public static String StoreCreditValue,Storeval1, Storeval2, StoreVal3, Storeval4, Storeval5,Storeval6, Storeval7,Storeval8,Storeval9,shippingCost, RANDOMCONST, RANDOMCONSTPlusStoreval1, RANDOMStoreval1, giftCertificatePayment;
	static double StoreCredit;
	
	ReadConfigFile file = new ReadConfigFile();
	
	
	
	public paymentPage_common() {
		PageFactory.initElements(driver(), this);
	}
	
	private String payWithCreditCard = "(//XCUIElementTypeButton[@name=\"Selection View\"])[4]";
	private String CCNumber = "(//XCUIElementTypeTextField[@name=\"Textfield\"])[1]";
	private String Name = "(//XCUIElementTypeTextField[@name=\"Textfield\"])[2]";
	private String expiry = "(//XCUIElementTypeTextField[@name=\"Textfield\"])[3]";
	private String billing = "(//XCUIElementTypeTextField[@name=\"Textfield\"])[4]";
	private String CVV = "(//XCUIElementTypeTextField[@name=\"Textfield\"])[5]";
	private String continueWithPaymentButton = "Continue with Payment";
	private String pay = "//*[contains(@text,\"Pay $\")]";
	private String pay2 = "//XCUIElementTypeButton[@name=\"Pay $6.64\"]";
	private String pay3 = "//XCUIElementTypeButton[@name=\"Pay $6.74\"]";
	private String againCVV = "Textfield";
	private String confirmButton = "//XCUIElementTypeStaticText[@name=\"Confirm\"]";
	private String done = "//XCUIElementTypeButton[@name=\"Done\" and @visible=\"true\"]";
	private String noTips="//XCUIElementTypeButton[@name=\"No Tip\"]";
	

	public void selectCreditCard() throws Exception{
		//scroll(payWithCreditCard);
		waitForElementClickable(payWithCreditCard, 20);
		System.out.println("cc got selected");
		Reporter.addStepLog("credit card got slected");
		
	}
	
	public void enterCreditCardDetails() throws Exception{
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		Thread.sleep(200);
		
	
		sendKeysUsingXpath(CCNumber, p.getProperty("CCNumber"));
		Reporter.addStepLog("credit card number: " +p.getProperty("CCNumber"));
		sendKeysUsingXpath(Name, p.getProperty("Name"));
		Reporter.addStepLog("name on credit card: " +p.getProperty("Name"));
		sendKeysUsingXpath(expiry, p.getProperty("Expiry"));
		Reporter.addStepLog("credit card expiry: " +p.getProperty("Expiry"));
		sendKeysUsingXpath(billing, p.getProperty("Billing"));
		Reporter.addStepLog("billing: " +p.getProperty("Billing"));
		sendKeysUsingXpath(CVV, p.getProperty("CVV"));
		Reporter.addStepLog("CVV: " +p.getProperty("CVV"));
		//driver().findElementByXPath("(//XCUIElementTypeTextField[@name=\"Textfield\"])[5]").sendKeys(Keys.ENTER);
		clickUsingName(continueWithPaymentButton);System.out.println("clicked on Continue with Payment");
		Reporter.addStepLog("tapped on continue payment button");
	}
	
	
	
	public void tapOnPay() throws Exception {
		Thread.sleep(8000);
		waitForElementClickable(pay, 9);
		Reporter.addStepLog("tapped on payment button once again");
		//clickUsingXPath(pay2);System.out.println("clicked on Pay $");
		//clickUsingXPath(pay);System.out.println("clicked on Pay $");
		
	}
	
	public void tapOnPayButtonShowingValues() throws Exception {
		Thread.sleep(8000);
		waitForElementClickable(pay, 9);
		Reporter.addStepLog("tapped on payment button once again");
		
	}
	public void tapOnNoTips() throws Exception {
		Thread.sleep(2000);
		waitForElementClickable(noTips, 15);
		Reporter.addStepLog("tapped on no tips");
		
	}
	
	
	
	public void againEnterCVVdetailsandConfirm() throws Exception{
		Thread.sleep(3000);
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		clickUsingName(againCVV); 
		sendKeysUsingName(againCVV, p.getProperty("CVV")); 
		Reporter.addStepLog("again CVV entered: " +p.getProperty("CVV"));
		System.out.println("again CVV added  "+ p.getProperty("CVV"));
		Thread.sleep(1000);
		clickUsingXPath(done); 
		Reporter.addStepLog("tapped on done");
		//driver().findElement(By.xpath("//XCUIElementTypeButton[@name=\"Done\" and @visible=\"true\"]")).click(); System.out.println("clicked on Done button");// click done button in keyboard
		Thread.sleep(1000);
//		JavascriptExecutor js = (JavascriptExecutor) driver();
//		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
//		clickUsingXPath(done); System.out.println("click on done button");
		clickUsingXPath(confirmButton); System.out.println("click on confirm button ");
		Reporter.addStepLog("tapped on confirm");
	}
	public void againEnterCVV2detailsandConfirm() throws Exception{
		Thread.sleep(3000);
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		clickUsingName(againCVV); 
		sendKeysUsingName(againCVV, p.getProperty("CVV2")); 
		Reporter.addStepLog("again CVV entered: " +p.getProperty("CVV2"));
		System.out.println("again CVV added  "+ p.getProperty("CVV2"));
		Thread.sleep(1000);
		clickUsingXPath(done); 
		Reporter.addStepLog("tapped on done");
		Thread.sleep(1000);
		clickUsingXPath(confirmButton); 
		System.out.println("click on confirm button ");
		Reporter.addStepLog("tapped on confirm");
	}
}
