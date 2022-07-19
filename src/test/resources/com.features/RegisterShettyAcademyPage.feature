Feature: Register Shetty Academy Page Feature

  Background:
    Given User navigates at the register Shetty page
    When User is on the register Shetty page

  Scenario: User validates login form and page title
    Then The login form should be displayed
    And Register Shetty title page should be "Let's Shop"

  Scenario: User validates social media links
    Then Social media amounts should be 4

  Scenario: User validates academy's an email address
    Then The academy's email address should be "dummywebsite@rahulshettyacademy.com"

  @F
  Scenario: Login with correct credentials
    And User enters an email address into the email field on the register Shetty page "dimagadjilla@gmail.com"
    And User enters a password into the password field on the register Shetty page "3036057Dr"
    And User clicks on the login button on the register Shetty page
    Then User navigates at the product Shetty page
    And Confirm success login pop up message should be "Login Successfully"

  Scenario: Login with incorrect credentials
    And User enters an wrong email address into the email field on the register Shetty page "dimagadjilla_@gmail.com"
    And User enters a wrong password into the password field on the register Shetty page "3036057_Dr"
    And User clicks on the login button on the register Shetty page
    Then User stays at the register Shetty page
    And Incorrect email or password pop up message should be "Incorrect email or password."

  @Smoke
  Scenario: User want to register
    And User clicks on the register button on the register Shetty page
    And User enters a first name for registration on the register Shetty page
    And User enters a last name for registration on the register Shetty page
    And User enters a email address name for registration on the register Shetty page
    And User enters a phone number for registration on the register Shetty page
    And User selects an occupation from drop down menu on the register Shetty page "Engineer"
    And User selects a gender on the register Shetty page
    And User enters a password for registration on the register Shetty page
    And User enters a confirm password for registration on the register Shetty page
    And User confirms that under eighteen on the register Shetty page
    Then User clicks on the login button for registration on the register Shetty page
    And Confirm success registration pop up message should be "Account Created Successfully"

