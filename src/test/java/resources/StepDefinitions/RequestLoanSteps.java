package resources.StepDefinitions;

import PageObjects.LoginPage;
import PageObjects.RequestLoanPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.base;

import java.io.IOException;
import java.util.List;

public class RequestLoanSteps extends base {

    private WebDriver driver;
    RequestLoanPage requestLoanPage;
    LoginPage userLogin;
    private static Logger log = LogManager.getLogger(RequestLoanSteps.class.getName());

    @Before("@Test3")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        log.info("Browser started successfully");

        requestLoanPage = new RequestLoanPage(driver);

        driver.get(prop.getProperty("url"));
        log.info("Navigating to url");
    }

    @Given("^I am am logged into para bank with a valid (.+) and (.+)$")
    public void i_am_am_logged_into_para_bank_with_a_valid_and(String username, String password){

        userLogin = new LoginPage(driver);

        userLogin.enterCustomerUsername(username);

        userLogin.enterCustomerPassword(password);

        userLogin.customerLogin();

        log.info("Customer is logged in successfully");
    }

    @When("^I click on request loan link$")
    public void i_click_on_request_loan_link() {

        requestLoanPage.getRequestLoanPage();

        log.info("Navigating to request loan page");
    }

    @Then("^I am taken to Apply for a Loan page$")
    public void i_am_taken_to_apply_for_a_loan_page(){

        log.info(requestLoanPage.validatePageTitle());
        Assert.assertEquals("Both text are different please check and try again","Apply for a Loan",
                      requestLoanPage.validatePageTitle().toString());

        log.info("Apply for loan page");
    }

    @And("^I enter loan details$")
    public void i_enter_loan_details(DataTable table){

        List<String> loanDetails = table.asList();

        requestLoanPage.enterLoanAmount(loanDetails.get(0));

        requestLoanPage.enterDownPaymentAmount(loanDetails.get(1));

        requestLoanPage.selectFromAccount();

        log.info("Customer entered loan details successfully");

    }

    @And("^I click on apply now$")
    public void i_click_on_apply_now(){

        requestLoanPage.clickApplyNow();

        log.info("Processing customers loan");
    }

    @And("^i should now be taken to loan confirmation screen$")
    public void i_should_now_be_take_to_loan_confirmation_screen() {
        waitExplicitlyForExpectedConditions(30, "#loanProviderName");

        String expectedProviderName;
        if(requestLoanPage.getLoanProviderName().equals("Wealth Securities Dynamic Loans (WSDL)")){
            expectedProviderName = "Wealth Securities Dynamic Loans (WSDL)";
        }else{
            expectedProviderName = "ParaBank";
        }

        log.info(requestLoanPage.getLoanProviderName());
        Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                expectedProviderName, requestLoanPage.getLoanProviderName());

        Assert.assertTrue("Response date is not displayed as expected please check and try again.",
                requestLoanPage.isResponseDateDisplayed());

        log.info(requestLoanPage.getLoanStatus());

        if(requestLoanPage.getLoanStatus().equals("Approved")){


            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Approved", requestLoanPage.getLoanStatus());

            log.info(requestLoanPage.getLoanConfirmationMessage());
            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Congratulations, your loan has been approved.",
                    requestLoanPage.getLoanConfirmationMessage());

            Assert.assertTrue("Account number is not displayed as expected please check and try again.",
                    requestLoanPage.isNewAccountIdDisplayed());

        } else if (requestLoanPage.getLoanDisapprovalMessage().equals("We cannot grant a loan in that " +
                "amount with your available funds.")){

            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Denied", requestLoanPage.getLoanStatus());

            log.info(requestLoanPage.getLoanDisapprovalMessage());
            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "We cannot grant a loan in that amount with your available funds.",
                    requestLoanPage.getLoanDisapprovalMessage());
        } else {

            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "Denied", requestLoanPage.getLoanStatus());

            log.info(requestLoanPage.getLoanDisapprovalMessage());
            Assert.assertEquals("Actual text is different from expected text. Please check and try again.",
                    "You do not have sufficient funds for the given down payment.",
                    requestLoanPage.getLoanDisapprovalMessage());
        }

        log.info("Validated loan screen successfully");


    }

    @After("@Test3")
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()){
            log.error("Test Failed");
            // Take screenshot and attach to report
            scenario.attach(getScreenshotWithoutPath(),
                    "image/png",
                    String.valueOf(scenario.getUri()));
            log.error("Took screenshot of failed test");
        }

        driver.close();

        log.info("Closing browser");
    }

}
