@Assignment
Feature: Assignment Scenarios

  @Assignment
  Scenario Outline: user wants to execute cryptocurrency case
    Given user enters API key
    And user hits currency mapping API
    And user gets the response
    And user validates status code
    Then user converts currency "<sourceCurrency>" into BOB
    And user validates status code

    Examples:
    | sourceCurrency |
    | BTC            |
    | USDT           |
    | ETH            |

    @Assignment
    Scenario: user wants to execute cryptocurrency info call
      Given user enters API key
      And user hits currency info API
      And user validates the response
      And user validates status code

    @Assignment
    Scenario: user wants to run case
      Given user wants to run case
      And user wants to scroll



