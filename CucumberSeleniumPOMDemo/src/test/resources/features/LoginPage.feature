Feature: Login page feature

  Scenario: Login page title
    Given user is on login page
    When user gets the title of the login page
    Then Login page title should be "SourceForge.net: Log In to SourceForge.net"

  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed

  Scenario Outline: Login with correct credentials
    Given user is on login page
    When user enters username "<userName>" and password "<password>"
    And user clicks on Login button
    Then user gets the title of the account page
    And Account page title should be "Compare B2B Software, Download, & Develop Open Source & Business Software - SourceForge"

    Examples: 
      | userName       | password      |
      | ssaisrinivas22 | $Ss9704312287 |
      | ssaisrinivas2  | $Ss9704312287 |
