Feature: Search Page

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    When User enters in the search field "T-shirt"
    And User clicks on the search button at the my account page

  Scenario: User navigates at the search page
    When User navigates at the search page
    Then Page title of the search page should be "Search - My Store"

  Scenario: User wants to validate search result
    Then User gets amount of search product
    And Product name contains the "Faded Short Sleeve T-shirts"
