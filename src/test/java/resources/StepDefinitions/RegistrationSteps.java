package resources.StepDefinitions;

import PageObjects.RegistrationPage;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import BasePage.base;

import java.io.IOException;
import java.util.List;

public class RegistrationSteps extends base {

    private WebDriver driver;
    RegistrationPage registrationPage;
    private static Logger log = LogManager.getLogger(RegistrationSteps.class.getName());

    @Before("@Test1")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        registrationPage = new RegistrationPage(driver);
        log.info("Browser started successfully");
    }

    @Given("^I navigate to para bank web application$")
    public void i_navigate_to_para_bank_web_application() {

        driver.get(prop.getProperty("url"));
        log.info("Navigating to url");
    }

    @When("^I click on register link$")
    public void i_click_on_register_link() {

        registrationPage.getRegistrationForm();
        log.info("Navigating to registration page");

    }

    @Then("^I enter my (.+) , (.+) and (.+) ,(.+)$")
    public void i_enter_my(String firstname, String lastname, String username, String password) {

        registrationPage.enterCustomersFullName(firstname, lastname);

        registrationPage.enterCustomersUsername(username);

        registrationPage.enterCustomersPassword(password);

        registrationPage.confirmCustomersPassword(password);
        log.info("Entered customers fullname and sign-on information");

    }

    @And("^I enter my street, city, state, zipcode and security security number$")
    public void i_enter_my_street_city_state_and_zipcode(DataTable table) {

        List<String> addressField = table.asList();

        registrationPage.enterCustomersFullAddress(addressField.get(0), addressField.get(1), addressField.get(2), addressField.get(3) );

        registrationPage.enterCustomersSocialSecurityNumber(addressField.get(4));

        log.info("Entered customers address details");
    }

    @And("^I click on register button$")
    public void i_click_on_register_button() {

        registrationPage.completeRegistration();

        log.info("Processing customers registration");

    }

    @Then("^I should be logged in$")
    public void i_should_be_logged_in() {

        // Check user already registered error message. The proceed with test.

        int size = driver.findElements(By.linkText("Log Out")).size();

        if(size > 0){


            waitExplicitlyForExpectedConditions(30,".title");

            registrationPage.validateAccountPageAfterRegistration();

            registrationPage.isCustomersWelcomeTextDisplayed();

            Assert.assertEquals("The actual welcome text message is different from what was expected. " +
                    "Please check and try again."
                    ,"Your account was created successfully. You are now logged in.",
                    registrationPage.getCustomerWelcomeText());

            registrationPage.loginOut();


        } else {

            registrationPage.isCustomerUsernameErrorDisplayed();

            Assert.assertEquals("The actual username error message is different from what was expected. " +
                            "Please check and try again."
                    ,"This username already exists.",registrationPage.getCustomerUsernameError());

            System.out.println(registrationPage.getCustomerUsernameError());
        }

        log.info("Customer is now logged in");

    }

    @After("@Test1")
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            log.error("Test Failed");
            // Take screenshot and embed to report
            scenario.attach(getScreenshotWithoutPath(),
                    "image/png",
                    String.valueOf(scenario.getUri()));
            log.error("Took screenshot of failed test");
        }

        driver.close();
        log.info("Closing browser");
    }

}
