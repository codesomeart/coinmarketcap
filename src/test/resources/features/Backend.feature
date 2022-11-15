@Assignment
Feature: Assignment Scenarios

  @Assignment
  Scenario Outline: user wants to execute cryptocurrency case
    Given user enters API key
    And user hits currency mapping API
    And user gets the response
    When user validates status code
    Then user converts currency "<sourceCurrency>" into BOB
    When user validates status code

    Examples:
    | sourceCurrency |
    | BTC            |
    | USDT           |
    | ETH            |
