package com.mindtree.CucumberFramework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.mindtree.CucumberFramework.pageObjects.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;



public class DriverFactory1 {

	public static BasePage basepage=new BasePage();
    protected static Map<Long, RemoteWebDriver> listOfDrivers = new HashMap<Long, RemoteWebDriver>();
    static Properties p = new Properties();
 	static FileInputStream fis = null;

	public static void setDriver() throws Exception {

		listOfDrivers.put(Thread.currentThread().getId(), initialize());

	}
	

	public static RemoteWebDriver driver() {

		return listOfDrivers.get(Thread.currentThread().getId());

	}

	public static RemoteWebDriver initialize() throws Exception {
		RemoteWebDriver driver = null;
		
		try {

			ReadConfigFile file = new ReadConfigFile();
//			ReadExcelltestData data = new ReadExcelltestData();
			String browser = "mobile";
			constant cc = new constant();
			switch (browser) {
			case "chrome":
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver", cc.CHROME_DRIVER_DIRECTORY);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;
			case "edge":
				if (driver == null) {
					System.setProperty("webdriver.edge.driver", cc.EDGE_DRIVER_DIRECTORY);
					driver = new EdgeDriver();
					driver.manage().window().maximize();
				}
				break;
			case "mobile":
			{
			
				URL url;
				String username = "santhu61";
				String accessKey = "82636d34-6b73-4828-8967-e515779752a6";
				String sauceUrl = "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

				String SAUCE_REMOTE_URL = "https://"+username+":"+accessKey+ sauceUrl;
				url = new URL(SAUCE_REMOTE_URL);



				MutableCapabilities capabilities = new MutableCapabilities();
				capabilities.setCapability("username", "username");
				capabilities.setCapability("accessKey", "accessKey");
				capabilities.setCapability("platformName", "iOS");
				capabilities.setCapability("appiumVersion", "1.21.0");

				capabilities.setCapability("automationName", "shakeShackIOS");
				capabilities.setCapability("appium:deviceName", "iPhone 12 Pro Max Simulator");
				capabilities.setCapability("appium:platformVersion", "14.4");
				//capabilities.setCapability("appium:app", "storage:3b628002-d68b-49b3-b8ab-74c87839cd2e");
				capabilities.setCapability("appium:app","storage:filename=Project Finley Staging_simulator.zip");
				MutableCapabilities sauceOptions = new MutableCapabilities();
				sauceOptions.setCapability("appiumVersion", "1.21.0");
				capabilities.setCapability("sauce:options", sauceOptions);
				driver = new RemoteWebDriver(url,capabilities);
			}
			case "sauceLabsRealDevice":
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
				  capabilities.setCapability("platformVersion", "14.8");
				  capabilities.setCapability("deviceName", "iPhone_12_Pro_Max_real_us");
				  capabilities.setCapability("app", "storage:b4fd4988-b7e6-4eba-b302-79682a7bf7d2");

				  driver = new IOSDriver<MobileElement>(url,capabilities);
//				capabilities.setCapability("username", "username");
//				capabilities.setCapability("accessKey", "accessKey");
//				capabilities.setCapability("platformName", "iOS");
//				//capabilities.setCapability("appiumVersion", "1.21.0");
//				capabilities.setCapability("idleTimeout", "90");
//				capabilities.setCapability("noReset", "false");
//				capabilities.setCapability("newCommandTimeout", "90");
//				capabilities.setCapability("platformVersion", "15.3");
//				capabilities.setCapability("deviceName", "iPhone_12_15_real_us");
////				  capabilities.setCapability("name", name.getMethodName());
//				  capabilities.setCapability("app", "storage:4818213b-1027-4e38-b014-d6709097b8c3");
//
//				
//				capabilities.setCapability("automationName", "shakeShackIOS");
//				capabilities.setCapability("appium:deviceName", "iPhone 12 Pro Max Simulator");
//				capabilities.setCapability("appium:platformVersion", "14.4");
//				//capabilities.setCapability("appium:app", "storage:3b628002-d68b-49b3-b8ab-74c87839cd2e");
//				capabilities.setCapability("appium:app","storage:filename=Project Finley Staging.zip");
//				MutableCapabilities sauceOptions = new MutableCapabilities();
//				sauceOptions.setCapability("appiumVersion", "1.21.0");
//				capabilities.setCapability("sauce:options", sauceOptions);
//				driver = new AppiumDriver<MobileElement>(url,capabilities);
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
				capabilities.setCapability("app", "bs://433abe9cdb16a33e33b06da19bccef79188361ea");
				capabilities.setCapability("name", "ShakeShack_iOS");
				capabilities.setCapability("browserstack.appium_version", "1.21.0");
				capabilities.setCapability("browserstack.debug", "true");
				driver = new RemoteWebDriver(url,capabilities);
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
