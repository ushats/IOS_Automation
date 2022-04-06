Feature: feature to test Pick-up order funcionality

  @CheckoutIndoorPick-up
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


 @CheckoutIndoorPick-upForSavedCC
  Scenario: Do indoor pickup checkout using saved Credit Cards
    Given user launch the ShackShack app and tap on Allow InPopup
    Then tap on next button and allow
    Then tap on pickup
    Then tap on find shack
    And enter the nearest shack or postalcode Address SearchField and Do StartOrder
    Then Tap On Indoor Pickup
    Then Tap On Burger category Select item
    Then select calories
    Then Add to Bag
    Then do Checkout
    And do Login with valid credentials
    Then Pay with saved Credit Card
    And verify the order summary page and receipt
    
  @CheckoutIndoorPick-upLoggedInUser
  Scenario: Launch shakeshack application and check the Landing page functionality
    Given user launch the ShackShack app and tap on Allow InPopup
    Then tap on next button and allow
    Then tap on SignIn in home page
    Then do Login with valid credentials
    Then tap on pickup
    Then tap on find shack
    And enter the nearest shack or postalcode Address SearchField and Do StartOrder
    Then Tap On Indoor Pickup
    Then Tap On Burger category Select item
    Then Add to Bag
    Then do Checkout
    Then Pay with Credit Card
    And verify the order summary page and receipt
    
   

