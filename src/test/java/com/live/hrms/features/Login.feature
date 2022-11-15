@Regression
Feature:Login
@UI
  Scenario: Login with valid crendentials and item add to cart
    Given Open browser
    When  Open URL  "https://demo.opencart.com/index.php?route=common/home&language=en-gb"
    Then  Click on MyAccount drop menu
    Then  Click on Login button
    Then  Enter  email  "poojireddy1990@gmail.com" and password "Nellore123$"
    Then  Click login
    Then  Click Phone&PDAs
    Then  Click HTC Touch HD
    Then   Add to cart and verify in items