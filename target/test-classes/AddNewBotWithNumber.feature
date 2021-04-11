@issue=AUDCUAT-1084
Feature: Add a new Bot

  Background: User is logged in
    Given The user is logged in
    Then The user click on the plus button

  Scenario: Validate all bot frameworks are displayed
    Then Validate that all Bot frameworks are displayed

  Scenario: Add a new Bot, assign a number to it and delete them
    When The user specifies the Bot framework
    And The user adds the Bot details
    And The user buys a number
    Then The bot and number are added
    When The user deletes the bot and number
    Then The bot and number are successfully deleted