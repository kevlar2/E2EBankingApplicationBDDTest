package resources.StepDefinitions;

import PageObjects.LoginPage;
import PageObjects.OpenANewAccountPage;
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
import java.util.Calendar;

public class OpenAnNewAccountSteps extends base {

    private WebDriver driver;
    OpenANewAccountPage openANewAccountPage;
    LoginPage userLogin;
    private String accountID;
    private final String accountType = "SAVINGS";
    private static Logger log = LogManager.getLogger(OpenAnNewAccountSteps.class.getName());

    @Before("@Test4")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        log.info("Browser started successfully");

        openANewAccountPage = new OpenANewAccountPage(driver);
        driver.get(prop.getProperty("url"));
        log.info("Navigating to url");
    }

    @Given("^I am logged into para bank with a valid (.+) and (.+)$")
    public void i_am_logged_into_para_bank_with_a_valid_and(String username, String password)  {

        userLogin = new LoginPage(driver);

        userLogin.enterCustomerUsername(username);

        userLogin.enterCustomerPassword(password);

        userLogin.customerLogin();

        log.info("Customer is logged in successfully");
    }

    @Then("^I navigate to the open new account page$")
    public void i_navigate_to_the_open_new_account_page() throws InterruptedException {

        openANewAccountPage.getOpenANewAccountForm();

        Assert.assertEquals("Actual url text is different from expected url text. Please check and try again",
               openANewAccountPage.pageUrl , openANewAccountPage.getUrl());

        Assert.assertEquals("Actual url text is different from expected url text. Please check and try again",
                "Open New Account" , openANewAccountPage.getPageTitle());

        log.info("Validating open new account page");

    }

    @And("^I select the required account information$")
    public void i_select_the_required_account_information()  {

        openANewAccountPage.selectAccountType(accountType);

        openANewAccountPage.selectAccountToTransferFrom();

        log.info("Selecting account information");

    }

    @And("^I click on open new account$")
    public void i_click_on_open_new_account() throws InterruptedException {

        Thread.sleep(1500);
        openANewAccountPage.clickOpenNewAccount();

        log.info("Open new account");
    }

    @Then("^I am taken to account confirmation page$")
    public void i_am_taken_to_account_confirmation_page()  {

        waitExplicitlyForExpectedConditionsXpath(30,
                "//p[contains(text(),'Congratulations, your account is now open.')]");


        log.info(openANewAccountPage.getAccountConfirmationMessage());

        Assert.assertEquals("Actual account confirmation text is different from expected text. Please check and try again",
                openANewAccountPage.accountConfirmationMessageText, openANewAccountPage.getAccountConfirmationMessage());

        log.info("Validating account confirmation message");
    }

    @When("^I click account number$")
    public void i_click_account_number()  {

        accountID = openANewAccountPage.getNewAccountID();

        openANewAccountPage.getAccountDetailsPage();

        log.info("Selecting account number");

    }

    @Then("^I should be taken account details page$")
    public void i_should_be_taken_account_details_page() throws Throwable {

        int month = Calendar.getInstance().get(Calendar.MONTH);

        //waitExplicitlyForExpectedConditions(30, "#accountId");

        Thread.sleep(1500);
        log.info("Validating account and transaction details");

        log.info(openANewAccountPage.getAccountNumber());
        Assert.assertEquals("Actual account ID is different from expected account number. Please check and try again",
                accountID , openANewAccountPage.getAccountNumber());

        log.info(openANewAccountPage.getAccountType());
        Assert.assertEquals("Actual type is different from expected account type. Please check and try again",
                accountType , openANewAccountPage.getAccountType());

        log.info( openANewAccountPage.getBalance() + " Balance : Available Balance "+ openANewAccountPage.getAvailableBalance());
        Assert.assertEquals("Actual balance is different from expected available Balance. Please check and try again",
                openANewAccountPage.getBalance() , openANewAccountPage.getAvailableBalance());


        log.info(monthSelector(month));
        openANewAccountPage.selectAccountMonth(monthSelector(month));

        openANewAccountPage.selectTransactionType("Credit");

        openANewAccountPage.clickOnGo();

        log.info(openANewAccountPage.conformTransactionOnAccount());

        Assert.assertTrue("'Funds Transfer Received' not displayed",
                openANewAccountPage.conformTransactionOnAccount().equals("Funds Transfer Received"));

        // Funds Transfer Received

        userLogin.customerLogout();

        log.info("Customer logs out successfully");

    }

    @After("@Test4")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
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
