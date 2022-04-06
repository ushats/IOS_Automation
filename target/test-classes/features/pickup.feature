Feature: feature to test Drive-up window order funcionality

  @CheckoutDriverUPWindowPickup
  Scenario: Launch shakeshack application and check the Landing page functionality
    Given user launch the ShackShack app and tap on Allow InPopup
    Then tap on next button and allow
    Then tap on pickup
    Then tap on find shack
    And enter the nearest shack or postalcode Address SearchField and Do StartOrder
    Then Tap On DriveUP Window Pickup
    Then Tap On Burger category Select item
    Then Add to Bag
    Then do Checkout
    And do Login with valid credentials2
    Then tap on No Tips
    Then Pay with saved Credit Card
    And verify the order summary page and receipt
    
     
    
  @smoke
  Scenario: Launch shakeshack application and check the Landing page functionality
    Given user launch the ShackShack app and tap on Allow InPopup
    Then tap on next button and allow
    Then do Login with valid credentials
    Then tap on pickup
    Then tap on find shack
    And enter the nearest shack or postalcode Address SearchField and Do StartOrder
    Then Tap On DriveUP Window Pickup
    Then Tap On Burger category Select item
    Then Add to Bag
    Then do Checkout
    Then Pay with Credit Card
    And verify the order summary page and receipt
    
      
    @smoke
  Scenario: Launch shakeshack application and check the Landing page functionality
    Given user launch the ShackShack app and tap on Allow InPopup
    Then tap on next button and allow
    
    Then do Login with valid credentials
    Then tap on pickup
    Then tap on find shack
    And enter the nearest shack or postalcode Address SearchField and Do StartOrder
    Then Tap On Curbside Pickup
    Then Tap On Burger category Select item
    Then Add to Bag
    Then do Checkout
    And do Login with valid credentials
    Then Pay with Credit Card
    And verify the order summary page and receipt