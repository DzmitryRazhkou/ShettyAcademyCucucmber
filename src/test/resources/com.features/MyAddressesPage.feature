Feature: My Addresses

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    When User clicks on the my addresses section

  Scenario: User navigates to my credit slips page
    Then User navigates at the my addresses page title
    And Page title of my addresses page should be "Addresses - My Store"

  Scenario: User wants to update personal address
    When User clicks on the update button at the addresses page
    And User enters first line of address for updating
    And User enters second line of address for updating
    And User enters phone number for updating address
    And User enters phone number for updating address
    And User enters additional data for updating address
    And User enters alias for updating address
    And User clicks on the save button at the addresses page
    Then User navigates at the my addresses page title
