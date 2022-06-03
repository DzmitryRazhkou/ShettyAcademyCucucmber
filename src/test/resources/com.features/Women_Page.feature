Feature: WomenPage

  Background:
    Given User is on the My store page
    When User clicks on the Women section

  Scenario: User validate women page
    Then User lands on the Women page

  Scenario: User wants set up check boxes on the women page
    When User makes check boxes checked on the women page
    Then Women result is "WOMEN > CATEGORIES DRESSES > SIZE L > COLOR ORANGE"
    And Women search result is "Printed Dress $26.00 In stock"

  Scenario: User wants adjust price using sliders
    When User adjusts price using sliders on the women page
    Then Women adjusted result is "Printed Dress $26.00 In stock"
    And Women adjusted search result is "Showing 1 - 1 of 1 items"

  Scenario: User wants sort products on the women page
    When User selects sorting by on the women page
    Then Women sorted result is "Printed Chiffon Dress $16.40 $20.50 -20% In stock"

