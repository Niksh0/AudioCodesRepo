Feature: Add credit to your account

  Background: User login
    Given The user logs in

  Scenario: Validate the billing rates
    When The user navigates to the Biling page
    Then Validate that all billing rates are correct

  Scenario: Add credit with valid card number
    When The user navigates to the Biling page
    And The user selects to add credit
    And The user fills in the card details
    And The user clicks on the Pay now button
    Then The payment is completed successfully

  Scenario: Add credit with 3D Secure card
    When The user navigates to the Biling page
    And The user selects to add credit
    And The user fills in the 3Ds card details
    And The user clicks on the Pay now button
    And The user enters the 3D secure password
    Then The 3D payment is completed successfully