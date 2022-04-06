package com.mindtree.CucumberFramework.stepDefinations;


import com.mindtree.CucumberFramework.pageObjects.BurgerCategoryAndItems;
import com.mindtree.CucumberFramework.pageObjects.DeliveryPage;
import com.mindtree.CucumberFramework.pageObjects.LoginPageCommon;
import com.mindtree.CucumberFramework.pageObjects.OrderConfirmation_common;
import com.mindtree.CucumberFramework.pageObjects.paymentPage_common;
import com.mindtree.CucumberFramework.pageObjects.pickup_common;
//import com.mindtree.CucumberFramework.utils.DriverFactory;
import com.mindtree.CucumberFramework.utils.DriverFactory2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ShakeShackIOSE2E extends LoginPageCommon{

	public static LoginPageCommon loginPage = new LoginPageCommon();
	public static BurgerCategoryAndItems BurgerAndItems= new BurgerCategoryAndItems();
	public static paymentPage_common paymentPage = new paymentPage_common();
	public static DriverFactory2 driverFactory = new DriverFactory2();
	public static OrderConfirmation_common orderConfirm = new OrderConfirmation_common();
	public static pickup_common pickup = new pickup_common();
	public static DeliveryPage deliveryPage =  new DeliveryPage();
	
	public ShakeShackIOSE2E() {
		
	}
	
	@Given("^user launch the ShackShack app and tap on Allow InPopup$")
	public void user_launch_the_ShackShack_app_and_tap_on_Allow_InPopup() throws Exception {
		loginPage.ClickOnAllowInPopup();
		
	}
	
		
	@Then("^tap on next button and tap On Pickup$")
	public void tap_on_next_button_and_tap_On_Pickup() throws Exception {
		loginPage.ClickOnNextButtonInAdvertizement();
		loginPage.clickOnPickupButtonInHomeScreen();
		
	}
	
	@Then("^tap on next button inAdvertizment$")
	public void tap_on_next_button_inAdvertizment() throws Exception {
		loginPage.ClickOnNextButtonInAdvertizement();
		
		
	}
	
	@Then("^tap on next$")
	public void tap_on_next() throws Exception {
		loginPage.ClickOnNextButton();
		
	}
	@Then("^tap on delivery$")
	public void tap_on_delivery() throws Exception{
		deliveryPage.clickOnDeliveryBtn();
	}
	@Then("^tap on SignIn in home page$")
	public void tap_on_SignIn_in_home_page() throws Exception{
		loginPage.tapOnSignInHomePage();
	}
	
	@Then("^tap on next button and allow$")
	public void tap_on_next_button_and_allow() throws Exception{
		loginPage.ClickOnNextButton();
	}
	
	@Then("^tap on pickup$")
	public void tap_on_pickup()throws Exception{
		loginPage.clickOnPickup();
	}
	
	@Then("^tap on find shack$")
	public void tap_on_find_shack() throws Exception {
		//loginPage.clickOnFindShack();
		loginPage.clickOnFindShackOrNotNowButton();
		//loginPage.popupPermissionAllowWhileUsingApp();
	}
	
	@Then("^tap on allow while using app$")
	public void tap_on_allow_while_using_app() throws Exception {
		loginPage.popupPermissionAllowWhileUsingApp();
	}
	
	@And("^enter the nearest shack or postalcode Address SearchField and Do StartOrder$")
	public void enter_the_nearest_shack_or_postalcode_Address_SearchField_and_Do_StartOrder() throws Exception {
		loginPage.enterTheNearestShackOrPostalCodeInTextField();
		loginPage.clickOnStartOrderButtonAndTapOnYepThatsCorrect();
	}
	
	@And("^enter the nearest shack2 or postalcode Address SearchField and Do StartOrder$")
	public void enter_the_nearest_shack2_or_postalcode_Address_SearchField_and_Do_StartOrder() throws Exception {
		loginPage.enterTheNearestShackOrPostalCodeInTextField2();
		loginPage.clickOnStartOrderButtonAndTapOnYepThatsCorrect();
	}
	
	@Then("^Tap On Indoor Pickup$")
	public void Tap_On_Indoor_Pickup() throws Exception{
		loginPage.selectIndoorPickup();
	}
	
	@Then("^Tap On Burger category Select item$")
	public void Tap_On_Burger_category_Select_Item() throws Exception{
		BurgerAndItems.clickOnBurgerMenu();
		BurgerAndItems.clickOnItemUnderBurger();
	}
	
	@Then("^select calories$")
	public void select_calories() throws Exception{
		BurgerAndItems.selectSingleCalories();
	}
	
	@Then("^Add to Bag$")
	public void Add_to_Bag() throws Exception{
		BurgerAndItems.addToBag();
	}
	
	@Then("^do Checkout$")
	public void checkout() throws Exception{
		BurgerAndItems.checkout();
	}
	
	@Then("^do checkout after login$")
	public void checkoutAfterLogin() throws Exception{
		BurgerAndItems.checkout3();
	}
	@And("^do Login with valid credentials$")
	public void loginWithValidCredentials() throws Exception{
		loginPage.loginWithValidCredentials();
	}
	
	@And("^do Login with valid credentials2$")
	public void loginWithValidCredentials2() throws Exception{
		loginPage.loginWithValidCredentials2();
	}
	
	@Then("^Pay with Credit Card$")
	public void Pay_with_Credit_Card() throws Exception{
		paymentPage.selectCreditCard();
		paymentPage.enterCreditCardDetails();
		paymentPage.tapOnPay();
		paymentPage.againEnterCVVdetailsandConfirm();
	}
	
	@Then("^Pay with saved Credit Card$")
	public void Pay_with_Saved_Credit_Card() throws Exception{
		paymentPage.tapOnPayButtonShowingValues();
		paymentPage.againEnterCVV2detailsandConfirm();
	}
	@And("^tap on No Tips")
	public void TapOnNoTips() throws Exception{
		paymentPage.tapOnNoTips();
	}
	
	@Then("^Pay with saved Credit Card3$")
	public void Pay_with_Saved_Credit_Card3() throws Exception{
		paymentPage.tapOnPayButtonShowingValues();
		paymentPage.againEnterCVV2detailsandConfirm();
	}
	
	
	@And("^verify the order summary page and receipt$")
	public void verify_the_order_summary_page_and_receipt() throws Exception{
		orderConfirm.notNowPopup();
		orderConfirm.OrderSummaryVerification();
		orderConfirm.receiptVerification();
	}
	
	
	@Then("^Tap On DriveUP Window Pickup$")
	public void Tap_On_DriveUP_Window_Pickup() throws Exception{
		pickup.tapOnDriveUpWindow();
		pickup.tapOnColor();
		pickup.tapOnAddColorButton();
		pickup.tapOnVehicleType();
		pickup.tapOnAddTypeButton();
		pickup.tapOnStartOrder();
		
	}
	
	
	//delivery order
	
	@Then("^tap on delivery button$")
	public void tap_on_delivery_button() throws Throwable {
		deliveryPage.clickOnDeliveryBtn();
	}
	@Then("^enter the delivery address$")
	public void enter_the_delivery_address() throws Throwable {
		deliveryPage.enterTheAddress();
		deliveryPage.selectTheAutoSuggestionAddress1();
	}


	@Then("^tap on next button$")
	public void tap_on_next_button() throws Throwable {
		deliveryPage.clickOnNextBtnOnAddressField();
	}
	
	@Then("^choose your delivery time$")
	public void choose_your_delivery_time() throws Throwable {
		deliveryPage.clickOnStartOderBtn();
	}
	
	
	@Then("^tap on History$")
	public void tap_on_History() {
		
	}
	
}
