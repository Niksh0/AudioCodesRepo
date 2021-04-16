Feature: Unassign a number and set Transfer call

  Background: Background steps
    Given The user has logged in
    When The user navigates to the Numbers page and selects a number

  Scenario: Unassign a number from a bot and assign it back afterwards
    And The user unassigns the number
    And The user assigns it back to the Bot
    Then The user validates that the number is assigned to the Bot

  Scenario: Specify a Transfer call number
    When The user specifies a transfer call numbers and updates
    And The user turns off the Transfer call feature
    Then The transfer call field is hidden
    When The user turns on the Transfer call feature
    Then The user clears the field and the number is updated