Feature: Order Page

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    When User enters in the search field "T-shirt"
    And User clicks on the search button at the my account page
    And User clicks on the showed product at the account page
    When User selects quantity of product at the faded short sleeve t-shirts page "1"
    And User selects size of product at the faded short sleeve t-shirts page "2"
    And User selects color of product at the faded short sleeve t-shirts page
    And User clicks at the add to cart button at the faded short sleeve t-shirts page

  Scenario: User navigates at the order page
    When User clicks at the proceed to order page
    And User navigates at the order page
    Then Page title of the order page should be "Order - My Store"

    Scenario: User validates prices on the order page
      When User clicks at the proceed to order page
      Then User validates prices