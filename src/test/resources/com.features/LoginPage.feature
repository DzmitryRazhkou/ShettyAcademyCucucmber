Feature: Login Page Feature

  Scenario: Login page title
    Given User is on login page
    When User gets the title of the page
    Then Page title should be "Login - My Store"

    Scenario: Forgot Password link
      Given User is on login page
      Then Forgot your password link should be displayed

      Scenario: Login with correct credentials
        Given User is on login page
        When User enters username "dimagadjilla@gmail.com"
        And User enters password "3036057Dr"
        And User clicks on login button
        Then User gets the title of the page
        And Page title should be "My account - My Store"