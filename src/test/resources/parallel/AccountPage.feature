Feature: Account Page Feature

  Background:
    Given User has already logged in to application
      | username               | password  |
      | dimagadjilla@gmail.com | 3036057Dr |

  Scenario: Account Page Title
    Given User is on Account Page
    When User gets the title of the page
    Then Page title should be "My account - My Store"

  Scenario: Accounts Section Count
    Given User is on Account Page
    Then User gets account section

      |ORDER HISTORY AND DETAILS|
      |MY CREDIT SLIPS|
      |MY ADDRESSES|
      |MY PERSONAL INFORMATION|
      |MY WISHLISTS|
      |Home|

    And Accounts section count should be 6
