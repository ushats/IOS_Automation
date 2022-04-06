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
import com.mindtree.CucumberFramework.execptions.WebDriverExceptions;
import com.mindtree.CucumberFramework.utils.ReadConfigFile;



public class pickup_common extends BasePage {
	Properties p = new Properties();
    FileInputStream fis = null;
	
	ReadConfigFile file = new ReadConfigFile();
	
	
	public pickup_common() {
		PageFactory.initElements(driver(), this);
	}
	
	private String driveUpWindow = "//XCUIElementTypeOther[@name=\"Drive-Up Window\"]";
	private String color ="Color (required)";
	private String addColorButton = "//XCUIElementTypeStaticText[@name=\"Add Color\"]";
	private String vehicleType = "Vehicle type (required)";
	private String addTypeButton = "//XCUIElementTypeStaticText[@name=\"Add Type\"]";
	private String startOrder = "//XCUIElementTypeStaticText[@name=\"Start Order\"]";
	
	
	//Drive-up window function 
	
	public void tapOnDriveUpWindow() throws Exception{
		waitForElementClickable(driveUpWindow, 30);
		System.out.println("clicked on Drive Pickup");
		
	}
	
	public void tapOnColor() throws Exception{
		waitForElementClickableByID(color, 2);
		System.out.println("clicked on color Pickup");
		
	}
	
	public void tapOnAddColorButton() throws Exception{
		clickUsingXPath(addColorButton); System.out.println("clicked on Add color");
	}
	
	public void tapOnVehicleType() throws Exception{
		clickUsingID(vehicleType); System.out.println("clicked on vehicle Type");
		
	}
	
	public void tapOnAddTypeButton() throws Exception{
		clickUsingXPath(addTypeButton); System.out.println("clicked on Add Type");
		
	}
	
	public void tapOnStartOrder() throws Exception{
		try{
			clickUsingName(startOrder);
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
}
