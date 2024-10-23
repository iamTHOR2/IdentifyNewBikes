@regression
Feature: Google Login

  Scenario: Login with invalid Google account details
    Given the user has the car sales website open in their browser
    When the user clicks on the login icon
    And the user clicks on the Google button
    And the user switches to the new window
    And the user enters the emailId and clicks on the Next button
    Then the system should display an error message and print it in the console
