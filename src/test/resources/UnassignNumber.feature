Feature: Unassign a number from Bot

  Scenario: Unassign a number from a bot and assign it back afterwards
    Given The user has logged in
    When The user navigates to the Numbers page and selects a number
    And The user unassigns the number
    And The user assigns it back to the Bot
    Then The user validates that the number is assigned to the Bot