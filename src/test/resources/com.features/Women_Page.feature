Feature: WomenPage

  Background:
    Given User is on the My store page
    When User clicks on the Women section

  Scenario: User validate women page
    Then User lands on the Women page

  Scenario: User wants set up check boxes
    When User makes check boxes checked
    Then Women result is "WOMEN > CATEGORIES DRESSES > SIZE L > COLOR ORANGE"
    And Women search result is "Printed Dress $26.00 In stock"

