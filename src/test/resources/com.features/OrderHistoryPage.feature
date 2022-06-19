Feature: My Order History Page

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    When User clicks on the order history and details section

  Scenario: User navigates to my wishes page
    And User navigates at the my wishes page title
    Then Page title of order history and details page should be "Order history - My Store"