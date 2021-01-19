Feature: Login Functionality

  In order to do internet banking
  As a valid Para Bank customer
  I want to log in successfully

  Scenario: Login Successful

    Given I am in the login page of the para bank web application
    When I enter a valid username and password
    When I click Log in
    And I should be taken to the Overview page