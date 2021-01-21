Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to log in successfully

  Scenario Outline: Login Successful

    Given I am in the login page of the para bank web application
    When I enter a valid <username> and <password> with <userFullName>
    When I click Log in
    And I should be taken to the Overview page

    Examples:

    |username     |password  |userFullName  |
    |autotester   |password  | Auto Tester  |
    |autotester2  |password2 | Auto Tester 2|
    |tautester    |password  | TAU Tester   |
