Feature: Register New OAuth2 Application Feature

  Background: 
    Given user has already logged in to application
      | username       | password      |
      | ssaisrinivas22 | $Ss9704312287 |
      
  Scenario Outline: Register New OAuth2 scenario with different set of data
    Given user navigates to OAuth2 page
    When user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on send button
    Then it shows a successful message "OAuth2 Client registered"

    Examples: 
      | SheetName          | RowNumber |
      | OauthRegisteration |         0 |
      | OauthRegisteration |         1 |
