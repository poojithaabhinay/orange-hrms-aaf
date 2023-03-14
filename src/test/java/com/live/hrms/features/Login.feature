@Regression
Feature:Login

  @UI1 @SmokeTest
  Scenario: Login with valid crendentials
    Given Open browser
    When Hotel app application
    Then Enter the username "alpharetta123" and password "w0Lu2FEA7a6ur0uQAV/Bzg==" and Click on Login button
    And Verify the  welcome text "Welcome to Adactin Group of Hotels" in hotel home page


  @UI2 @SmokeTest
Scenario:  verify the check-out date field accepts a later date than check-in date.
  Given Open browser
  When Hotel app application
  Then Enter the username "alpharetta123" and password "w0Lu2FEA7a6ur0uQAV/Bzg==" and Click on Login button
  Then Enter the data in all fields and click search button
  |columnName |value|
  |Location   |Sydney|
  |Hotels     |Hotel Creek|
  |Room Type   |Standard  |
  |Number Of Rooms|1 - One|
  |Check In Date|15/03/2023|
  |Check Out Date|13/03/2023|
  |Adults per Room      |1 - One|
  |Children per Room       |2 - Two|
    And Verify the page should display "Check-In Date shall be before than Check-Out Date"

  @UI3 @SmokeTest
  Scenario:  Check if error is date field is in the past
    Given Open browser
    When Hotel app application
    Then Enter the username "alpharetta123" and password "w0Lu2FEA7a6ur0uQAV/Bzg==" and Click on Login button
    Then Enter the data in all fields and click search button
      |columnName |value|
      |Location   |Sydney|
      |Hotels     |Hotel Creek|
      |Room Type   |Standard  |
      |Number Of Rooms|1 - One|
      |Check In Date|04/03/2023|
      |Check Out Date|06/03/2023|
      |Adults per Room   |   1 - One |
      |Children per Room |1 - One  |

  @UI4 @SmokeTest
  Scenario:Verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
    Given Open browser
    When Hotel app application
    Then Enter the username "alpharetta123" and password "w0Lu2FEA7a6ur0uQAV/Bzg==" and Click on Login button
    Then Enter the data in all fields and click search button
      |columnName |value|
      |Location   |Sydney|
      |Hotels     |Hotel Creek|
      |Room Type   |Standard  |
      |Number Of Rooms|1 - One|
      |Check In Date|04/03/2023|
      |Check Out Date|06/03/2023|
      |Adults per Room   |   1 - One |
      |Children per Room |1 - One  |
    And Verify the location is displayed in select hotel page


