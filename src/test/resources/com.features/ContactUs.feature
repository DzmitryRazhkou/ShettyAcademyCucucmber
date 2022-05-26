Feature: Contact Us Feature
  Scenario Outline: Contact Us scenario with different set of data
    Given User navigates to contact us page
    When User fills the form from given sheet name "<SheetName>" and row number <RowNumber>
    And User clicks on the send button
    Then It shows a successful message "Your message has been successfully sent to our team."
    Examples:
      | SheetName | RowNumber |
      | ContactUs | 0 |
      | ContactUs | 1 |