@Issue("AUDCUAT-1084")
Feature: Add a new Bot

  Scenario: Add a new Bot, assign a number to it and delete them
    Given The user is logged in
    When The user click on the plus button
    And The user specifies the Bot framework
    And The user adds the Bot details
    And The user buys a number
    Then The bot and number are added
    When The user deletes the bot and number
    Then The bot and number are successfully deleted