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
    And User enters additional data for updating address
    And User enters alias for updating address
    And User clicks on the save button at the addresses page
    Then User navigates at the my addresses page title

  Scenario: User wants to update personal address
    When User clicks on the add new address button at the addresses page
    And User enters first line of address for updating
    And User enters second line of address for updating
    And User enters first line of address for updating
    And User enters city name for creating new address
    And User selects state name for creating new address
    And User enters zipcode for creating new address
    And User enters phone number for updating address
    And User enters additional data for updating address
    And User enters alias for updating address
    And User clicks on the save button at the addresses page
    Then User navigates at the my addresses page title

  Scenario: User wants to delete address
    When User clicks on the delete button at the addresses page
    Then User navigates at the my addresses page title

  Scenario: User clicks on the back to your account button
    And User clicks on the back to your account button at the address page
    Then Page title of my account page should be "My account - My Store"

  Scenario: User clicks on the home button
    And User clicks on the home button at the address page
    Then Page title of my store page should be "My Store"


