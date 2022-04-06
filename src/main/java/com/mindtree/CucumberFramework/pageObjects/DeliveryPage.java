package com.mindtree.CucumberFramework.pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;
import com.mindtree.CucumberFramework.execptions.WebDriverExceptions;
import com.mindtree.CucumberFramework.utils.ReadConfigFile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSTouchAction;

public class DeliveryPage extends BasePage {

	Properties p = new Properties();
    FileInputStream fis = null;
	
	ReadConfigFile file = new ReadConfigFile();
	
	
	
	public DeliveryPage() {
		PageFactory.initElements(driver(), this);
	}
	
	private String allowWhileUsingApp = "Allow While Using App";

	private String deliveryBtn = "//*[@name=\"Delivery\"]";//XCUIElementTypeButton[@name="Delivery"]
	
	private String addressBtn = "//XCUIElementTypeOther[@name=\"225 Varick Street, New York, NY, USA\"]";
	
	private String addressInputField = "(//XCUIElementTypeTextField[@name=\"Textfield\"])[1]";
	private String autoSuggestion="//XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]";
	private String autoSuggestion2="//XCUIElementTypeOther[@name=\"225 Varick Street, New York, NY, USA\"]";
	@FindBy(xpath = " //XCUIElementTypeOther[@name=\"225 Varick Street, New York, NY, USA\"]")
	public WebElement selectAddress;
	
	
	private String NxtBtnAddressField = "//XCUIElementTypeButton[@name=\"Next\"]";
	//private String startOrderBtn = "//XCUIElementTypeButton[@name=\"Delivery\"]";
	
	
	
	private String startOrderBtn = "//XCUIElementTypeStaticText[@name=\"Start Order\"]";
	
	public void clickOnAllowButton() throws Exception {
		clickUsingName(allowWhileUsingApp);
		System.out.println("allow permission popup Allow While Using App");
	}
	
   public void clickOnDeliveryBtn() throws Exception {
	   clickUsingXPath(deliveryBtn);
	   Reporter.addStepLog("successfully tapped on delivery button");
	   System.out.println("tapped on delivery");
	   //clickUsingXPath(deliveryBtn);
	}
   
   public void enterTheAddress() throws Exception {
	   try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
	   //waitForElementClickable(deliveryBtn, 10);
		Thread.sleep(5000);
	   sendKeysUsingXpath(addressInputField,p.getProperty("DeliveryAddress1"));
	   driver().findElementByXPath("(//XCUIElementTypeTextField[@name=\"Textfield\"])[1]").sendKeys(Keys.ENTER);
	   Reporter.addStepLog("entered the delivery address :"+p.getProperty("DeliveryAddress1"));
	   System.out.println("entered the delivery address :"+p.getProperty("DeliveryAddress1"));
	   //clickUsingXPath(addressBtn);
	   
	}
   
   public void selectTheAutoSuggestionAddress1() throws Exception{
	   clickUsingXPath(autoSuggestion);
	   System.out.println("auto suggestions selected");
	   
   }
   
   public void clickOnNextBtnOnAddressField() throws Exception {
	   //waitForElementClickable(deliveryBtn, 10);
	   clickUsingXPath(NxtBtnAddressField);
	   Reporter.addStepLog("tap on next button in Shack to Door Step page");
	   System.out.println("tapped on next in Shack to Door-step");
  	}
   
   public void clickOnStartOderBtn() throws Exception {
	   waitForElementClickable(startOrderBtn, 40);
	   clickUsingXPath(startOrderBtn);
	   System.out.println("tapped on start order button");
	   Reporter.addStepLog("successfully tapped start order button");
  	}
   public void selectTheDeliveryTimings() {
		
 	}
   
   public void clickOnStartOrder() {
		
	}
   
   public void clickOnItem() {
		
  	}
   
   public void clickOnAddToBag() {
		
 	}
   
   public void clickOnCheckOutButton() {
		
	}
   
   public void loginWithValidCredential() {
		
	}
	
	
}
