@Regression
Feature:Login

  @UI
  Scenario: Login with valid crendentials and item add to cart
    Given Open browser
    When Open cart application "https://demo.opencart.com/index.php?route=common/home&language=en-gb"
  #  Then Click on Login button
   # Then Enter  email address "poojireddy1990@gmail.com" and password "Nellore123$" and click login
    Then  Click Phone&PDAs
    Then  Click HTC Touch HD
    Then   Add to cart
   # Then  verify in items