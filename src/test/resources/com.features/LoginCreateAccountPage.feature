Feature: Create New Account Feature

  Background:
    Given User is on the My store page
    And User clicks on the sign in button

  Scenario Outline: User fills up the required fields with personal data

    When User enters create "<emailCreate>"
    And User clicks on the create account button

    And User enters into the title field
    And User enters into the firstname field "<firstname>"
    And User enters into the lastname field "<lastname>"
    And User enters into the password field "<password>"
    And User enters into the days "<dayOfDOB>"
    And User enters into the months "<monthOfDOB>"
    And User enters into the years "<yearOfDOB>"
    And User enters into the company field "<company>"
    And User enters into the first line address field "<addressFl>"
    And User enters into the last line address field "<addressSl>"
    And User enters into the city field "<city>"
    And User enters into the state field "<state>"
    And User enters into the zipcode field "<zip>"
    And User enters into the additional info field "<addInfo>"
    And User enters into the mobile phone "<phone>"

    And User clicks on the register button
    Then User is on Account Page
    Examples:
      | emailCreate                 | firstname | lastname | password      | dayOfDOB | monthOfDOB | yearOfDOB | company        | addressFl         | addressSl | city        | state      | zip   | addInfo       | phone        |
      | noah_smithgregson@gmail.com | Noah      | Smith    | f_fgh_jkl4566 | 13       | May        | 1985      | Noah Smith LLC | 915 N 15th Street | Z-301     | Los Angeles | California | 90028 | Apartment 305 | (323)7867520 |
