Feature: Successful Login edited

  Scenario: Login with valid username and password
    Given User navigates to the login page
    When User enters email and password
    And User clicks on the login button
    Then User is successfully logged in