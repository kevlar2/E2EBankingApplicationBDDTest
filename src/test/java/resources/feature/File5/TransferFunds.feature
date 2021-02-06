Feature: Transfer Funds Functionality

    In order to Transfer funds as valid para bank customer
    I want to log in successfully
    I want to navigate to Transfer funds page
    I want to enter amount to Transfer and account details 
    I want to complete transfer successfully 

    @Test5
    Scenario Outline: Transfer funds successfully

        Given That I am logged into para bank with a valid <username> and <password>
        Then I navigate to transfer funds page
        And I enter amount to transfer and account details
        And I click transfer 
        Then I should be taken transfer complete page

Examples:

    | username     | password  |
    | autotester   | password  |
    | autotester2  | password2 |
    | taunewtester | password  |