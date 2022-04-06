package com.mindtree.CucumberFramework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.rules.TestName;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.cucumber.listener.Reporter;
import com.mindtree.CucumberFramework.pageObjects.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;



public class DriverFactory2 {

	public static BasePage basepage=new BasePage();
    protected static Map<Long, AppiumDriver<MobileElement>> listOfDrivers = new HashMap<Long, AppiumDriver<MobileElement>>();
	
    static Properties p = new Properties();
 	static FileInputStream fis = null;

	public static void setDriver() throws Exception {

		listOfDrivers.put(Thread.currentThread().getId(), initialize());

	}
	
	public TestName name = new TestName() {
		 public String getMethodName() {
		 return String.format("%s", super.getMethodName());
		 }
	};

	

	public static RemoteWebDriver driver() {

		return listOfDrivers.get(Thread.currentThread().getId());

	}

	public static AppiumDriver<MobileElement> initialize() throws Exception {
		try {
			fis = new FileInputStream("./DataSource/Data.Properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		p.load(fis);
		AppiumDriver<MobileElement> driver = null;
		
		try {

			ReadConfigFile file = new ReadConfigFile();
//			ReadExcelltestData data = new ReadExcelltestData();
			String browser = "sauceLabs";
			constant cc = new constant();
			switch (browser) {
//			case "chrome":
//				if (driver == null) {
//					System.setProperty("webdriver.chrome.driver", cc.CHROME_DRIVER_DIRECTORY);
//					driver = new ChromeDriver();
//					driver.manage().window().maximize();
//				}
//				break;
//			case "edge":
//				if (driver == null) {
//					System.setProperty("webdriver.edge.driver", cc.EDGE_DRIVER_DIRECTORY);
//					driver = new EdgeDriver();
//					driver.manage().window().maximize();
//				}
//				break;
			case "sauceLabs":
			{
			//working code
				URL url;
				String username = "ArunShanmukha";
				String accessKey = "934aef68-2bbb-4d9f-b7bb-b2456c5fe900";
				String sauceUrl = "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

				String SAUCE_REMOTE_URL = "https://"+username+":"+accessKey+ sauceUrl;
				url = new URL(SAUCE_REMOTE_URL);

				MutableCapabilities capabilities = new MutableCapabilities();
				capabilities.setCapability("idleTimeout", "90");
				  //capabilities.setCapability("noReset", "false");
				  capabilities.setCapability("newCommandTimeout", "90");
				  capabilities.setCapability("platformName", "iOS");
				  capabilities.setCapability("platformVersion", p.getProperty("iOSPlatformVersion"));
				  capabilities.setCapability("deviceName", p.getProperty("iOSDeviceName"));
				  capabilities.setCapability("app", "storage:"+p.getProperty("StorageBuild"));
				  driver = new IOSDriver<MobileElement>(url,capabilities);

			}
			break;
			case "browserStack":
			{
			
				URL url;
				String username = "arns_wvfPnj";
				String accessKey = "rj46oEsh2Ye4tWUsnCmp";
				String browserStack = "@hub-cloud.browserstack.com/wd/hub";

				String browserStack_URL = "http://"+username+":"+accessKey+ browserStack;
				url = new URL(browserStack_URL);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("os_version", "14");
				capabilities.setCapability("platformName", "iOS");
				capabilities.setCapability("device", "iPhone 12 Pro");
				capabilities.setCapability("app", "bs://fe56cbb7d2ac92638dd12d7a914995232d526474");
				capabilities.setCapability("name", "ShakeShack_iOS");
				capabilities.setCapability("browserstack.appium_version", "1.21.0");
				capabilities.setCapability("browserstack.debug", "true");
				capabilities.setCapability("browserstack.networkProfile", "4g-lte-advanced-good");
				driver = new IOSDriver<MobileElement>(url,capabilities);
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			}
			
			}
			
			

		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
//			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		return driver;
	}

}
