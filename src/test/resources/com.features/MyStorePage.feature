Feature: MyStorePage

  Background:
    Given User is on the MyStorePage

  Scenario: User gets logo on the MyStorePage
    Then Logo is displayed
    And Then Page title of my store page should be "My Store"

  Scenario: User clicks on the contact us button
    When User clicks on the contact us button
    Then User navigates on at the contact us "Contact us - My Store"

  Scenario: User clicks on the sign in button
    When User clicks on the sign in button
    Then User navigates on at the login page "Login - My Store"

  Scenario: User gets name of sections
    Then User retrieves names of account section

      | WOMEN    |
      | DRESSES  |
      | T-SHIRTS |

    And Accounts section is 3

  Scenario: User gets Information section
    Then User gets section from information footer
      | Specials                    |
      | New products                |
      | Best sellers                |
      | Our stores                  |
      | Contact us                  |
      | Terms and conditions of use |
      | About us                    |
      | Sitemap                     |

    And Footer has 8 sections


