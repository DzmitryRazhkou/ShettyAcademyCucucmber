Feature: Your Personal Information

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button

  Scenario: User navigates to my identity page
    When User clicks on the my order history and details section
    Then User navigates at the my identity page title
    And Page title of identity page should be "Identity - My Store"

  Scenario: Personal information
    When User clicks on the my order history and details section
    Then User receives personal data
      | Dzmitry                |
      | Razhkou                |
      | dimagadjilla@gmail.com |
      | 28/May/1990            |

  Scenario: User clicks on the back to your account button
    When User clicks on the my order history and details section
    And User clicks on the back to your account button
    Then Page title of my account page should be "My account - My Store"

  Scenario: User clicks on the home button
    When User clicks on the my order history and details section
    And User clicks on the home button
    Then Page title of my store page should be "My Store"