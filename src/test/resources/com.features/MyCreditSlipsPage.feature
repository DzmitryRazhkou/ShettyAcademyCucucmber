Feature: My Credit Slips Page

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button

  Scenario: User navigates to my credit slips page
    When User clicks on the my credit slips section
    Then User navigates at the my credit slips page title
    And Page title of my credit slips page should be "Order slip - My Store"

  Scenario: User wants to get my credit slips message
    When User clicks on the my credit slips section
    Then User can see message "You have not received any credit slips."

  Scenario: User clicks on the back to your account button
    When User clicks on the my credit slips section
    And User clicks on the back to your account button
    Then Page title of my account page should be "My account - My Store"

  Scenario: User clicks on the home button
    When User clicks on the my credit slips section
    And User clicks on the home button
    Then Page title of my store page should be "My Store"
