Feature: Successful Login edited

  Background: Navigate to the login page
    Given User navigates to the login page

  @severity=critical
  Scenario: Login with valid username and password
    When User enters email and password
    And User clicks on the login button
    Then User is successfully logged in

  Scenario: Attempt to login with invalid credentials
    When User enters invalid credentials
    And User attempts to log in
    Then User receives an error message

  Scenario: Attempt to login with nonexistent user
    When User enters nonexistent email
    And User tries to log in
    Then Error for nonexistent user is displayed