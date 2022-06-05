Feature: T-Shirts Page

  Background:
    Given User is on the My store page
    When User clicks on the t-shirts section

  Scenario: User validate t-shirts page
    Then User lands on the T-shirts page

  Scenario: User wants set up check boxes on the t-shirts page
    When User makes check boxes checked on the t-shirts page
    Then T-shirts result is "T-SHIRTS > SIZE L > COLOR ORANGE"
    And T-shirts search result is "Faded Short Sleeve T-shirts $16.51 In stock"

  Scenario: User wants adjust price using sliders
    When User adjusts price using sliders on the t-shirts page
    Then T-shirts adjusted result is "Faded Short Sleeve T-shirts $16.51 In stock"
    And T-shirts adjusted search result is "Showing 1 - 1 of 1 item"

  Scenario: User wants sort products on the t-shirts page
    When User selects sorting by on the t-shirts page
    Then T-shirts sorted result is "Faded Short Sleeve T-shirts $16.51 In stock"