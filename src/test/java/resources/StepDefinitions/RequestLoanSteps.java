package resources.StepDefinitions;

import PageObjects.LoginPage;
import PageObjects.RequestLoanPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.base;

import java.io.IOException;
import java.util.List;

public class RequestLoanSteps extends base {

    public WebDriver driver;

    RequestLoanPage requestLoanPage;

    LoginPage userLogin;

    @Before("@Test3")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        requestLoanPage = new RequestLoanPage(driver);
        driver.get(prop.getProperty("url"));
    }

    @Given("^I am am logged into para bank with a valid (.+) and (.+)$")
    public void i_am_am_logged_into_para_bank_with_a_valid_and(String username, String password) throws Throwable {

        userLogin = new LoginPage(driver);

        userLogin.enterCustomerUsername(username);

        userLogin.enterCustomerPassword(password);

        userLogin.customerLogin();
    }

    @When("^I click on request loan link$")
    public void i_click_on_request_loan_link() throws Throwable {

        requestLoanPage.getRequestLoanPage();
    }

    @Then("^I am taken to Apply for a Loan page$")
    public void i_am_taken_to_apply_for_a_loan_page() throws Throwable {

        System.out.println(requestLoanPage.validatePageTitle());
        Assert.assertEquals("Both text are different please check and try again","Apply for a Loan",
                      requestLoanPage.validatePageTitle().toString());
    }

    @And("^I enter loan details$")
    public void i_enter_loan_details(DataTable table) throws Throwable {

        List<String> loanDetails = table.asList();

        requestLoanPage.enterLoanAmount(loanDetails.get(0));

        requestLoanPage.enterDownPaymentAmount(loanDetails.get(1));

        requestLoanPage.selectFromAccount();

    }

    @And("^I click on apply now$")
    public void i_click_on_apply_now() throws Throwable {

        requestLoanPage.clickApplyNow();
    }

    @And("^i should now be taken to loan confirmation screen$")
    public void i_should_now_be_take_to_loan_confirmation_screen() throws Throwable {
        waitExplicitlyForExpectedConditions(30, "#loanProviderName");

        System.out.println(requestLoanPage.getLoanProviderName());
        Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                "ParaBank", requestLoanPage.getLoanProviderName());

        Assert.assertTrue("Response date is not displayed as expected please check and try again.",
                requestLoanPage.isResponseDateDisplayed());

        System.out.println(requestLoanPage.getLoanStatus());

        if(requestLoanPage.getLoanStatus().equals("Approved")){

            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Approved", requestLoanPage.getLoanStatus());

            System.out.println(requestLoanPage.getLoanConfirmationMessage());
            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Congratulations, your loan has been approved.",
                    requestLoanPage.getLoanConfirmationMessage());

            Assert.assertTrue("Account number is not displayed as expected please check and try again.",
                    requestLoanPage.isNewAccountIdDisplayed());

        } else if (requestLoanPage.getLoanDisapprovalMessage().equals("We cannot grant a loan in that " +
                "amount with your available funds.")){

            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Denied", requestLoanPage.getLoanStatus());

            System.out.println(requestLoanPage.getLoanDisapprovalMessage());
            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Account number is not displayed as expected please check and try again.",
                    requestLoanPage.getLoanDisapprovalMessage());
        } else {

            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Denied", requestLoanPage.getLoanStatus());

            System.out.println(requestLoanPage.getLoanDisapprovalMessage());
            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "You do not have sufficient funds for the given down payment.",
                    requestLoanPage.getLoanDisapprovalMessage());
        }














    }

    @After("@Test3")
    public void tearDown(){
        driver.close();
    }

}
