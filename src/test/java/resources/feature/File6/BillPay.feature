Feature: Bill Pay Functionality

  In order to pay bills as a valid para bank customer
  I want to log in successfully
  i want to navigate to bill pay page
  I want to enter payment details
  I want to complete payment successfully

  @Test6
  Scenario Outline: Pay Bill successfully

    Given I am logged in with a valid <username> and <password>
    Then I click on bill pay link
    And I enter payee information <payeeName>, <accountNumber>, <amount>
    And Click send payment
    Then I should be taken to payment confirmation screen

    Examples:

      | username     | password  | payeeName      | accountNumber | amount |
      | autotester   | password  | Auto Tester 2  | 125645        | 500    |
      | autotester2  | password2 | Tau New Tester | 567897        | 800    |
      | taunewtester | password  | Auto Tester    | 896754        | 1000   |