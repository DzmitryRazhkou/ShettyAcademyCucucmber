Feature: Login Page Feature

  Background:
    Given User is on the My store page
    When User clicks on the sign in button

  Scenario: Login Page title
    And User gets the title of the page
    Then Page title should be "Login - My Store"

  Scenario: Forgot Password link
    Then Forgot your password link should be displayed

  Scenario: Login with correct credentials
    When User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    Then User gets the title of the page
    And Page title should be "My account - My Store"

  Scenario: Login with incorrect credentials
    When User enters email {gans}
    And User enters password {123}
    Then An error form is displayed

  Scenario Outline: Create Account with different emails
    When User enters create "<email>"
    And User clicks on the create account button
    Then User gets the title of the page
    And Page title should be "Login - My Store"

    Examples:
      | email                 |
      | noahsmith@gmail.com   |
      | oliverreyes@gmail.com |
      | lucasevans@gmail.com  |
      | jamestaylor@gmail.com |
      | alexlewis@gmail.com   |