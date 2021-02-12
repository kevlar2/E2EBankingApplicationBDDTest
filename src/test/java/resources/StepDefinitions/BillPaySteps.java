package resources.StepDefinitions;

import PageObjects.BillPayPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import resources.base;

import java.io.IOException;

public class BillPaySteps extends base {

    private WebDriver driver;
    BillPayPage bilPayPage;

    String billPayPageExpectedUrl = "https://parabank.parasoft.com/parabank/billpay.htm";

    @Before("@Test6")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        bilPayPage = new BillPayPage(driver);
        driver.get(prop.getProperty("url"));

    }

    @Given("^I am logged in with a valid (.+) and (.+)$")
    public void i_am_logged_in_with_a_valid_and(String username, String password) {

        bilPayPage.userLogin(username, password);

    }

    @Then("^I click on bill pay link$")
    public void i_click_on_bill_pay_link() throws Throwable {

        bilPayPage.getBillPayPage();

        Assert.assertEquals("Expected page url is not equal to actual url. Please check",
                billPayPageExpectedUrl,bilPayPage.validatePageUrl());
    }

    @And("^I enter payee information (.+), (.+), (.+)$")
    public void i_enter_payee_information_(String payeeName, String accountNumber, String amount) {

        bilPayPage.enterPayeeName(payeeName);

        bilPayPage.enterPayeeAddress("44 London Road");
        bilPayPage.enterPayeeAddressCity("London");
        bilPayPage.enterPayeeAddressState("Greater London");
        bilPayPage.enterPayeeAddressZipCode("SW15 5TT");
        bilPayPage.enterPayeePhoneNumber("07845635647");
        bilPayPage.enterPayeeAccountNumber(accountNumber);
        bilPayPage.verifyPayeeAccountNumber(accountNumber);
        bilPayPage.selectFromAccountNumber();
        bilPayPage.enterAmount(amount);


    }

    @And("^Click send payment$")
    public void click_send_payment() throws Throwable {

        bilPayPage.clickSendPayment();

    }

    @Then("^I should be taken to payment confirmation screen$")
    public void i_should_be_taken_to_payment_confirmation_screen() throws Throwable {

        waitExplicitlyForExpectedConditions(30,
                "div[ng-show='showResult'] p:nth-child(2)");

        System.out.println(bilPayPage.getBillPaymentConfirmationMessage());

        Assert.assertTrue("Bill payment confirmation message is not displayed. Please check",
                bilPayPage.isBillPaymentConfirmationMessageDisplayed());

        Assert.assertTrue("Amount is not displayed. Please check",
                bilPayPage.isBillPaymentConfirmationAmountDisplayed());

        Assert.assertTrue("Account number is not displayed. Please check",
                bilPayPage.isBillPaymentConfirmationFromAccountNumberDisplayed());

        Assert.assertTrue("Account activity message is not displayed. Please check",
                bilPayPage.isBillPaymentAccountActivityMessage());

        bilPayPage.userLogsOut();
    }

    @After("@Test6")
    public void tearDown(Scenario scenario) {

        if(scenario.isFailed()){
            // Take screenshot and attach to report
            scenario.attach(getScreenshotWithoutPath(),
                    "image/png",
                    String.valueOf(scenario.getUri()));
            System.out.println("Took screenshot of failed test");
        }

        driver.close();
    }

}
