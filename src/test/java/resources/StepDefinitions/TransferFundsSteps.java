package resources.StepDefinitions;

import PageObjects.TransferFundsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import BasePage.base;

import java.io.IOException;

public class TransferFundsSteps extends base {

    private WebDriver driver;
    public TransferFundsPage transferFundsPage;
    private static Logger log = LogManager.getLogger(TransferFundsSteps.class.getName());

    @Before("@Test5")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        log.info("Browser started successfully");

        transferFundsPage = new TransferFundsPage(driver);

        driver.get(prop.getProperty("url"));
        log.info("Navigating to url");
    }

    @Given("^That I am logged into para bank with a valid (.+) and (.+)$")
    public void i_am_logged_into_para_bank_with_a_valid_and(String username, String password) {

        transferFundsPage.userLogin(username, password);

        log.info("Customer is logged in successfully");
    }

    @Then("^I navigate to transfer funds page$")
    public void i_navigate_to_transfer_funds_page() {

        transferFundsPage.getTransferFundsPage();

        log.info("Navigating to transfer funds page");
    }

    @And("^I enter amount to transfer and account details$")
    public void i_enter_amount_to_transfer_and_account_details() throws InterruptedException {

        Thread.sleep(2000);

        transferFundsPage.selectFromAccount();

        transferFundsPage.selectToAccount();

        transferFundsPage.enterAmount("1000");

        log.info("Enter selected amount and account details");


    }

    @And("^I click transfer$")
    public void i_click_transfer() {
        transferFundsPage.processTransfer();

        log.info("Amount transferred");
    }

    @Then("^I should be taken transfer complete page$")
    public void i_should_be_taken_transfer_complete_page() {

        waitExplicitlyForExpectedConditionsXpath(30, "//div[@id='rightPanel']//p[1]");

        Assert.assertTrue("The Transfer confirmation message is not displayed, please check. ",
                transferFundsPage.isTransferConfirmationDisplayed());

        Assert.assertTrue("The expected transfer amount is not displayed, please check. ",
                    transferFundsPage.isTransferredAmountDisplayed());

        Assert.assertTrue("The transfer from account number is not displayed, please check.",
                    transferFundsPage.isTransferFromAccountIdDisplayed());

        Assert.assertTrue("The transfer to account number is not displayed, please check. ",
                    transferFundsPage.isTransferToAccountIdDisplayed());

        Assert.assertTrue("The activity text is not displayed, please check. ",
                    transferFundsPage.isAccountActivityTextDisplayed());

        log.info("Validating payment complete page");

        transferFundsPage.userLogsOut();

        log.info("Logging out");

    }

    @After("@Test5")
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
