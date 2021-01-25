Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to log in successfully

  @Test2
  Scenario Outline: Login Successful

    Given I am in the login page of the para bank web application
    When I enter a valid <username> and <password> with <userFullName>
    When I click Log in
    And I should be taken to the Overview page

    Examples:

    |username        |password  |userFullName              |
    |autotester      |password  | Welcome Auto Tester      |
    |autotester2     |password2 | Welcome Auto Tester 2    |
    |taunewtester    |password  | Welcome Tau New Tester   |
