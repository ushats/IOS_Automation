package com.mindtree.CucumberFramework.pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.Reporter;
import com.mindtree.CucumberFramework.execptions.WebDriverExceptions;
import com.mindtree.CucumberFramework.utils.DriverFactory1;
import com.mindtree.CucumberFramework.utils.DriverFactory2;
import com.mindtree.CucumberFramework.utils.ReadConfigFile;

import io.appium.java_client.MobileElement;



public class BasePage extends DriverFactory2 {
	Properties p = new Properties();
    FileInputStream fis = null;
    ExtentReports extent;
    ExtentTest test;
    
	public static ExtentTest logger;
	
	ReadConfigFile file = new ReadConfigFile();

	public BasePage() {
	}

	private static String screenshotName;
	public WebDriverWait wait;

	public void mouseHoverClick(WebElement target) throws InterruptedException {
		Actions action = new Actions(driver());
		action.moveToElement(target).perform();
		action.doubleClick(target);
		JavascriptExecutor js = (JavascriptExecutor) driver();
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", target);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", target);

	}

	public void javascriptClick( WebElement target) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver();

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", target);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", target);

	}

	public void scroll1() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver();
			js.executeScript("window.scrollBy(0,1000)");
		} catch (Exception e) {
			throw new TestException("Not able to scroll down", e);
		}

	}

	public void alertaccept() {
		try {
			driver().switchTo().alert().accept();
		} catch (Exception e) {
			throw new TestException("Not able to accept in alert box", e);
		}

	}

	public void clear(WebElement element) throws WebDriverExceptions {
		try {
			element.clear();
		} catch (Exception e) {
			throw new WebDriverExceptions("Not able to clear the field", e);
		}

	}

	public void maximize() {
		try {
			driver().manage().window().maximize();
		} catch (Exception e) {
			throw new TestException("Not able to maximize the browser", e);
		}
	}

	public void sendKeys(WebElement element, String key) throws Exception {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					element);
			element.clear();
			element.sendKeys(key);

		} catch (Exception e) {
			throw e;
		}
	}
	
	public void sendKeysUsingXpath(String element, String key) throws Exception {
		try {

//			JavascriptExecutor js = (JavascriptExecutor) driver();
//			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
//					element);
			WebElement element1 = driver().findElementByXPath(element);
			element1.clear();
			element1.sendKeys(key);

		} catch (Exception e) {
			throw e;
		}
	}
	
	public void sendKeysUsingName(String element, String key) throws Exception {
		try {
//			JavascriptExecutor js = (JavascriptExecutor) driver();
//			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
//					element);
			WebElement element1 = driver().findElementByName(element);
			element1.clear();
			element1.sendKeys(key);

		} catch (Exception e) {
			throw e;
		}
	}
	
	public void sendKeysUsingID(String element, String key) throws Exception {
		try {

			WebElement element1 = driver().findElementById(element);
			element1.clear();
			element1.sendKeys(key);

		} catch (Exception e) {
			throw e;
		}
	}
	

	public void click(WebElement element) {
		try {
			
			long waitTime = (long) Double.parseDouble("20");
			WebDriverWait wait = new WebDriverWait(driver(), waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			
//			JavascriptExecutor js = (JavascriptExecutor) driver();
//			js.executeScript("arguments[0].click();",element);
			Thread.sleep(1000);
			element.click();
		} catch (Exception e) {
			//throw  e;
		}

	}
	
	public void clickMobile(WebElement element) throws TimeoutException{
		 waitForElementClickable(element,1);
		element.click();

	}
	
	 public void waitForElementClickable( WebElement element,int time) throws TimeoutException{
	        WebDriverWait wait = new WebDriverWait(driver(),time);
			wait.until(ExpectedConditions.elementToBeClickable(element));

	    }
	
	public void waitForElementClickable(By by, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver(), waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(by));

	}
	public void waitForVisible(By by, int waitTime) {
	   	  WebDriverWait wait = new WebDriverWait(driver(), waitTime);
	   	    for (int attempt = 0; attempt < waitTime; attempt++) {
	   	        try {
	   	            driver().findElement(by);
	   	            break;
	   	        } catch (Exception e) {
	   	            driver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	   	        }
	   	    }
	}
	
	public void waitForElementToBeInVisible(By by, int timeoutInSeconds) {

		try {
			wait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS)
					.until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (org.openqa.selenium.StaleElementReferenceException e) {

			e.printStackTrace();
		}
	}
	
	public void clickElement(String element) {// working code
		try {
			WebElement element1 = driver().findElementByXPath(element);
//			JavascriptExecutor executor = (JavascriptExecutor)driver();
//			executor.executeScript("arguments[0].click();", element1);
			element1.click();
		} catch (Exception e) {
			throw  e;
		}

	}
	
	public void clickUsingXPath(String element) throws Exception {
		try {
			
			WebElement element1 = driver().findElementByXPath(element);
			Thread.sleep(1000);
			element1.click();
		} catch (Exception e) {
			throw  e;
		}
	}
	
	public void clickUsingName(String element) throws Exception {
		try {
			WebElement element1 = driver().findElementByName(element);
			Thread.sleep(1000);
			element1.click();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void clickUsingID(String element) throws Exception {
		
		try {
			
			WebElement element1 = driver().findElementById(element);
			Thread.sleep(1000);
			element1.click();
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void waitForElementVisible(String element,int time) throws Exception {
		try{
				WebDriverWait wait = new WebDriverWait(driver(), time);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				
		}catch(StaleElementReferenceException e){
				throw e;
			
		}
		
    }
	
	public void waitForElementClickableByName( String element,int time) throws TimeoutException{
		
		WebElement myElement = (new WebDriverWait(driver(), time)).until(ExpectedConditions.presenceOfElementLocated(By.name(element)));
        myElement.click();
		System.out.println("clicked in wait method");
    }
	public void waitForElementClickableByID( String element,int time) throws TimeoutException{
		WebElement myElement = 
        		(new WebDriverWait(driver(), time)).until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
        myElement.click();
		System.out.println("clicked in wait method");
    }
	public void waitForElementClickable( String element,int time) throws TimeoutException{
		WebElement myElement = 
        		(new WebDriverWait(driver(), time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
        myElement.click();
		System.out.println("clicked in wait method");
    }
	
	public void waitForClick(By element){
		
	}


	public void actionEnter() throws WebDriverExceptions {
		try {
			
			Actions actions = new Actions(driver());
			actions.keyDown(Keys.ENTER);
			actions.keyUp(Keys.ENTER);
		} catch (Exception e) {
			throw new WebDriverExceptions("Not able to enter", e);
		}

	}
	

	public void actionEnter( WebElement element) throws WebDriverExceptions {
		try {
			long waitTime = (long) Double.parseDouble("20");
			WebDriverWait wait = new WebDriverWait(driver(), waitTime);
			wait.until(ExpectedConditions.visibilityOf(element));
			JavascriptExecutor js = (JavascriptExecutor) driver();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					element);
			Thread.sleep(1000);
			Actions actions = new Actions(driver());
			actions.click(element).perform();
		} catch (Exception e) {
			throw new WebDriverExceptions("Not able to double click", e);
		}

	}

	public WebElement WaitforVisibility(WebElement ele) {

		long waitTime = (long) Double.parseDouble("20");
		WebDriverWait wait = new WebDriverWait(driver(), waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		JavascriptExecutor js = (JavascriptExecutor) driver();
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		return ele;

	}

	public String getText(String element) throws WebDriverExceptions {
		try {
			
//			int time = 2;
//			WebElement myElement =  (new WebDriverWait(driver(), time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
			WebElement element1 = driver().findElementByXPath(element);
			String text = element1.getText();
			System.out.println(text);
			Reporter.addStepLog(text);
			return text;
		} catch (Exception e) {
			throw new WebDriverExceptions("Not able to get text", e);
		}

	}
	
	public String getTextUsingID(String element) throws WebDriverExceptions {
		try {
			
			WebElement element1 = driver().findElementById(element);
			String text = element1.getText();
			System.out.println(text);
			return text;
		} catch (Exception e) {
			throw new WebDriverExceptions("Not able to get text", e);
		}

	}
	

	public String getColor(WebElement element) throws WebDriverExceptions {
		try {
			
			long waitTime = (long) Double.parseDouble("20");
			WebDriverWait wait = new WebDriverWait(driver(), waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			JavascriptExecutor js = (JavascriptExecutor) driver();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
					element);
			String textcolor = element.getCssValue("color").trim();
			
			 String color_hex[];  
			 color_hex = textcolor.replace("rgba(", "").split(",");       
			 String actual_hex = String.format("#%02x%02x%02x", Integer.parseInt(color_hex[0].trim()), Integer.parseInt(color_hex[1].trim()), Integer.parseInt(color_hex[2].trim()));
			
			return actual_hex;
		} catch (Exception e) {
			throw new WebDriverExceptions("Not able to get text", e);
		}

	}

	public void Enter(WebElement element) throws WebDriverExceptions {
		try {
			element.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			throw new WebDriverExceptions("Not able Enter : Error Message " + e.getMessage());
		}

	}

	public WebElement WaitforVisibilityIfPresentAndClose(WebElement ele) throws WebDriverExceptions {
		try {
			long waitTime = (long) Double.parseDouble("20");
			WebDriverWait wait = new WebDriverWait(driver(), waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			JavascriptExecutor js = (JavascriptExecutor) driver();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
			ele.click();
			return ele;
		} catch (Throwable e) {
			throw new WebDriverExceptions("Element not present : Error Message " + e.getMessage());
		}
	}
	
	public WebElement selectOptionText(WebElement ele,String text) throws WebDriverExceptions {
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
			 Select select=new Select(ele);
			 select.selectByVisibleText(text);
			return ele;
		} catch (Throwable e) {
			throw new WebDriverExceptions("Not able select value : Error Message " + e.getMessage());
		}
	}

	public WebElement selectOptionvalue(WebElement ele,String value) throws WebDriverExceptions {
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver();
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
			 Select select=new Select(ele);
			 select.selectByValue(value);
			return ele;
		} catch (Throwable e) {
			throw new WebDriverExceptions("Not able select value : Error Message " + e.getMessage());
		}
	}

	
	public static String timeStamp(String fileExtension) {
		
		Date d=new Date();
		String date=d.toString().replace(":", "_").replace(" ", "_")+fileExtension;
		return date;
		
	}
	
	public void CaptureScreenShot() throws IOException {
        File srcfile=((TakesScreenshot) driver()).getScreenshotAs(OutputType.FILE);
        screenshotName=timeStamp(".png");
        FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"\\output\\images\\"+screenshotName));
        Reporter.addStepLog("Error Screenshot");
        Reporter.addStepLog("<a target=\"_blank\", href="+returnScreenShotName()+"><img src="+returnScreenShotName()+" style=\"width:30% ; height: 80vh \" ></img></a>");
        
    }
    public static String returnScreenShotName() {
        return (System.getProperty("user.dir")+"\\output\\images\\"+ screenshotName).toString();
    }
	
	
	public void scroll(String toScroll) {
		WebElement element = driver().findElementByXPath(toScroll);
		TouchActions action = new TouchActions(driver());
		action.scroll(element, 10, 100);
		action.perform();
	}
	
}
