Feature: Request Loan Functionality

  In order to request a Loan
  As a valid Para Bank customer
  I want to log in successfully
  I want to navigate to request loan page
  I want to request a loan successfully

  @Test3
  Scenario Outline: Request a Loan Successfully

    Given I am am logged into para bank with a valid <username> and <password>
    When I click on request loan link
    Then I am taken to Apply for a Loan page
    And I enter loan details
          |1000|500|
    And I click on apply now
    And i should now be taken to loan confirmation screen

    Examples:

    |username     |password  |
    |autotester   |password  |
    |autotester2  |password2 |
    |taunewtester |password  |
