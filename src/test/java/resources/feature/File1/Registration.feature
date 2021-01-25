Feature: Customer Registration

  In order to do internet banking
  As a new Para Bank customer
  I want to register for internet banking

  @Test1
Scenario Outline: Successful Registration

  Given I navigate to para bank web application
  When I click on register link
  Then I enter my <FirstName> , <LastName> and <Username> ,<Password>
  And I enter my street, city, state, zipcode and security security number
       | Putney High Road | Putney | London | 135647 | 2454748484 |
  And I click on register button
  Then I should be logged in


  Examples:

  |FirstName|LastName  |Username     |Password    |
  |Auto     |Tester    | autotester   |password    |
  |Auto     |Tester 2  | autotester2  |password2   |
  |Tau      |New Tester| taunewtester |password    |

