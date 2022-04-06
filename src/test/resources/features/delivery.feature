Feature: Feature to test Delivery  page functionality


@DELIVERY
  Scenario: Verify user is able to place an order by selecting delivery method 
    Given user launch the ShackShack app and tap on Allow InPopup
    Then tap on next
    Then tap on delivery button
    Then enter the delivery address 
   	And tap on next button
   	Then choose your delivery time
    Then Tap On Burger category Select item
   
    Then Add to Bag
    Then do Checkout
    Then do Login with valid credentials
    Then Pay with Credit Card
    And verify the order summary page and receipt   