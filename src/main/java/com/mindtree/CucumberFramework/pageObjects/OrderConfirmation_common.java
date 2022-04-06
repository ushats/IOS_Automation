package com.mindtree.CucumberFramework.pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import com.mindtree.CucumberFramework.utils.ReadConfigFile;



public class OrderConfirmation_common extends BasePage {
	Properties p = new Properties();
    FileInputStream fis = null;
    public static String StoreCreditValue,Storeval1, Storeval2, StoreVal3, Storeval4, Storeval5,Storeval6, Storeval7,Storeval8,Storeval9,shippingCost, RANDOMCONST, RANDOMCONSTPlusStoreval1, RANDOMStoreval1, giftCertificatePayment;
	static double StoreCredit;
	
	ReadConfigFile file = new ReadConfigFile();
	
	
	
	public OrderConfirmation_common() {
		PageFactory.initElements(driver(), this);
	}
	
	private String notNowPopup = "Not Now";
	private String OrderConfirmationHeader = "//XCUIElementTypeStaticText[@name=\"Header Label\"]";
	private String shackName = "//XCUIElementTypeStaticText[@name=\"Location Label\"]";
	private String shackAddress = "//XCUIElementTypeStaticText[@name=\"Address Label\"]";
	private String orderMessage = "//XCUIElementTypeStaticText[@name=\"Order Confirmation Message Label\"]";
	private String pickUpTime = "//XCUIElementTypeStaticText[@name=\"Pick-Up Time Label\"]";
	private String orderNumber = "//XCUIElementTypeStaticText[@name=\"Order Number Label\"]";
	private String orderTotal = "//XCUIElementTypeStaticText[@name=\"Order Total Label\"]";
	private String viewReceiptButton = "//XCUIElementTypeButton[@name=\"View Receipt\"]";
	
	private String contactInfo = "Selection View";
	private String subTotalBagFeeTaxTotalInfo ="//XCUIElementTypeApplication[@name=\"Project Finley Staging\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]";
	private String doneInReceipt = "Done";
	

	public void notNowPopup() throws Exception{
		waitForElementClickableByName(notNowPopup, 90); 
		System.out.println("clicked on Not Now in rating popup");
		
	}
	
	public void OrderSummaryVerification() throws Exception{
//		getTextUsingID(OrderConfirmationHeader);
//		getTextUsingID(shackName);
//		getTextUsingID(shackAddress);
//		getTextUsingID(orderMessage);
//		getTextUsingID(pickUpTime);
//		getTextUsingID(orderNumber);
//		getTextUsingID(orderTotal);
		Thread.sleep(5000);
		clickUsingID(viewReceiptButton);
		System.out.println("clicked on view receipt");
		
	}
	
	public void receiptVerification() throws Exception{
		getTextUsingID(contactInfo);
		getText(subTotalBagFeeTaxTotalInfo);
		getTextUsingID(doneInReceipt);
		
		
	}
	
	
}
