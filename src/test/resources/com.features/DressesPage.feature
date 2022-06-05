Feature: Dresses Page

  Background:
    Given User is on the My store page
    When User clicks on the Dresses section

  Scenario: User validate dresses page
    Then User lands on the Dresses page

  Scenario: User wants set up check boxes on the dresses page
    When User makes check boxes checked on the dresses page
    Then Dresses result is "DRESSES > CATEGORIES SUMMER DRESSES > SIZE L > COLOR ORANGE"
    And Dresses search result is "Printed Summer Dress $28.98 $30.51 -5% In stock"

  Scenario: User wants adjust price using sliders
    When User adjusts price using sliders on the dresses page
    Then Dresses adjusted result is "Printed Dress $26.00 In stock"
    And Dresses adjusted search result is "Showing 1 - 1 of 1 items"

  Scenario: User wants sort products on the dresses page
    When User selects sorting by on the dresses page
    Then Dresses sorted result is "Printed Chiffon Dress $16.40 $20.50 -20% In stock"