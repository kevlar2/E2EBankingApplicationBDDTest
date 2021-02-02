Feature: Open a New Account Functionality

  In order to open a new Account
  As a valid Para Bank customer
  I want to log in successfully
  I want to navigate to open new account page
  I want to complete the new account opening process successfully

  @Test4
  Scenario Outline: Open a new account successfully
    
    Given I am logged into para bank with a valid <username> and <password>
    Then I navigate to the open new account page
    And I select the required account information
    And I click on open new account
    Then I am taken to account confirmation page
    When I click account number
    Then I should be taken account details page

Examples:
    | username     | password  |
    | autotester   | password  |
    | autotester2  | password2 |
    | taunewtester | password  |

    