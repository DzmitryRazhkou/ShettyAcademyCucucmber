Feature: Faded Short Sleeve T-Shirts Page

  Background:
    Given User is on the My store page
    When User clicks on the sign in button
    And User enters email "dimagadjilla@gmail.com"
    And User enters password "3036057Dr"
    And User clicks on the login button
    When User enters in the search field "T-shirt"
    And User clicks on the search button at the my account page
    And User clicks on the showed product at the account page

  Scenario: User navigates at the faded short sleeve t-shirts page
    When User navigates at the faded short sleeve t-shirts page
    Then Page title of the faded short sleeve t-shirts page should be "Faded Short Sleeve T-shirts - My Store"

  Scenario: User wants to write a review
    When User clicks on the write review button at the faded short sleeve t-shirts page
    And User selects star content quality at the faded short sleeve t-shirts page
    And User enters the title of review in the text field at the faded short sleeve t-shirts page
    And User enters the comment in the text field at the faded short sleeve t-shirts page
    And User clicks on the send review button at the faded short sleeve t-shirts page
    Then New review comment message should be "Your comment has been added and will be available once approved by a moderator"

  Scenario: User wants to send to a friend
    When User clicks on the send to friend button at the faded short sleeve t-shirts page
    And User enters the name of the friend in the text field at the faded short sleeve t-shirts page
    And User enters the email address of your friend in the text field at the faded short sleeve t-shirts page
    And User clicks on the send email button at the faded short sleeve t-shirts page
    Then New review email message should be "Your e-mail has been sent successfully"

  Scenario: User wants to add to wish list
    When User clicks on the add to wishlist button at the faded short sleeve t-shirts page
    Then New wish list message should be "Added to your wishlist."