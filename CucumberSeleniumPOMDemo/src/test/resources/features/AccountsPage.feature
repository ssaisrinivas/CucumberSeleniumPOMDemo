Feature: Account Page Feature

  Background: 
    Given user has already logged in to application
      | username       | password      |
      | ssaisrinivas22 | $Ss9704312287 |

  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the account page
    Then page title should be "ssaisrinivas22 / Preferences"

  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      | My profile and my projects             |
      | Activity I follow                      |
      | Set avatar icon                        |
      | Disable account                        |
      | How to use Multifactor authentication. |
      | Set up multifactor authentication.     |
      | Documentation                          |
    And accounts section count should be 7
