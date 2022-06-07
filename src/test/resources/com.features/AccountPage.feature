Feature: Account Page Feature

  Background:
    Given User is on the My store page
    And User clicks on the sign in button
    When User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button


  Scenario: Account Page Title
    When User gets the title of the page
    Then Page title should be "My account - My Store"

  Scenario: Accounts Section Count
    Then User gets account section

      |ORDER HISTORY AND DETAILS|
      |MY CREDIT SLIPS|
      |MY ADDRESSES|
      |MY PERSONAL INFORMATION|
      |MY WISHLISTS|
      |Home|

    And Accounts section count should be 6
