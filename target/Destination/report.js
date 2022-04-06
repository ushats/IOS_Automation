$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/landing.feature");
formatter.feature({
  "line": 1,
  "name": "feature to test Pick-up order funcionality",
  "description": "",
  "id": "feature-to-test-pick-up-order-funcionality",
  "keyword": "Feature"
});
formatter.before({
  "duration": 40865380200,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Do indoor pickup checkout using saved Credit Cards",
  "description": "",
  "id": "feature-to-test-pick-up-order-funcionality;do-indoor-pickup-checkout-using-saved-credit-cards",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 20,
      "name": "@CheckoutIndoorPick-upForSavedCC"
    }
  ]
});
formatter.step({
  "line": 22,
  "name": "user launch the ShackShack app and tap on Allow InPopup",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "tap on next button and allow",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "tap on pickup",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "tap on find shack",
  "keyword": "Then "
});
formatter.step({
  "line": 26,
  "name": "enter the nearest shack or postalcode Address SearchField and Do StartOrder",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "Tap On Indoor Pickup",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Tap On Burger category Select item",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "select calories",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "Add to Bag",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "do Checkout",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "do Login with valid credentials",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Pay with saved Credit Card",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "verify the order summary page and receipt",
  "keyword": "And "
});
formatter.match({
  "location": "ShakeShackIOSE2E.user_launch_the_ShackShack_app_and_tap_on_Allow_InPopup()"
});
formatter.result({
  "duration": 3470038500,
  "status": "passed"
});
formatter.match({
  "location": "ShakeShackIOSE2E.tap_on_next_button_and_allow()"
});
formatter.result({
  "duration": 23151381900,
  "status": "passed"
});
formatter.match({
  "location": "ShakeShackIOSE2E.tap_on_pickup()"
});
formatter.result({
  "duration": 2928654300,
  "status": "passed"
});
formatter.match({
  "location": "ShakeShackIOSE2E.tap_on_find_shack()"
});
formatter.result({
  "duration": 4998043600,
  "status": "passed"
});
formatter.match({
  "location": "ShakeShackIOSE2E.enter_the_nearest_shack_or_postalcode_Address_SearchField_and_Do_StartOrder()"
});
formatter.result({
  "duration": 32213829300,
  "status": "passed"
});
formatter.match({
  "location": "ShakeShackIOSE2E.Tap_On_Indoor_Pickup()"
});
formatter.result({
  "duration": 3985394600,
  "status": "passed"
});
formatter.match({
  "location": "ShakeShackIOSE2E.Tap_On_Burger_category_Select_Item()"
});
