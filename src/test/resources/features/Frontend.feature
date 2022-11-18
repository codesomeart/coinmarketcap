@frontend
Feature: Frontend Scenarios

  @frontend
  Scenario: user wants to click on rows filter dropdown
    Given user lands on coinmarketcap website
    And user wants to scroll
    Then user clicks on row filter dropdown
    And user validates the number of rows

  @frontend
  Scenario: user wants to run case
    Given user lands on coinmarketcap website
    Then user clicks on filter button
    And user selects price filter
    Then user selects market-cap filter
    And user validates both filters
