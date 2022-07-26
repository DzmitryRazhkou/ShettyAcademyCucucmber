Feature: Product Shetty Academy Page Feature

  Background:
    Given User navigates at the register Shetty page
    When User is on the register Shetty page
    And User enters an email address into the email field on the register Shetty page "dimagadjilla@gmail.com"
    And User enters a password into the password field on the register Shetty page "3036057Dr"
    And User clicks on the login button on the register Shetty page

  Scenario: User wants to validate product page title
    When User navigates at the product Shetty page
    And Product Shetty title page should be "Let's Shop"

  @F
  Scenario: User validates the amounts of the products
    When User navigates at the product Shetty page
    Then User retrieves product on the product Shetty page
    And The amount of the products should be 3

  Scenario: User performs a search product
    When User enters product name at the product Shetty page "iphone"
    Then Product name should be "IPHONE 13 PRO"

  Scenario: User adds product to cart
    When User enters product name at the product Shetty page "iphone"
    When User clicks on the add to cart button
    Then Add to cart green confirmation message is appeared

  Scenario: User clicks on the cart button
    When User enters product name at the product Shetty page "iphone"
    And User clicks on the add to cart button
    And User clicks on the cart button
    Then User navigates at the my cart Shetty page

  Scenario: User proceeds to the check out button
    When User enters product name at the product Shetty page "iphone"
    And User clicks on the add to cart button
    And User clicks on the cart button
    And User clicks on the proceed to check out button "IPHONE 13 PRO"
    Then User navigates at the payment Shetty page

  Scenario: User wants to log out
    When User clicks at the log out button
    Then Log out green confirmation message is showed up