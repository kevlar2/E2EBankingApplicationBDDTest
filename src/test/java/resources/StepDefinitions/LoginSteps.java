package resources.StepDefinitions;

import PageObjects.LoginPage;
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
import BasePage.base;

import java.io.IOException;

public class LoginSteps extends base {

    private WebDriver driver;
    LoginPage loginPage;
    private final base baseUtil;
    public LoginSteps(base util){

        this.baseUtil =util;
    }
    private static final Logger log = LogManager.getLogger(LoginSteps.class.getName());

    @Before("@Test2")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        log.info("Browser started successfully");
        driver.get(prop.getProperty("url"));
        log.info("Navigating to url");

    }

    @Given("^I am in the login page of the para bank web application$")
    public void i_am_in_the_login_page_of_the_para_bank_web_application() {

        loginPage = new LoginPage(driver);

        log.info("Getting login page");
    }

    @When("^I enter a valid (.+) and (.+) with (.+)$")
    public void i_enter_a_valid_username_and_password(String username, String password, String userFullName) {

        baseUtil.userFullName = userFullName; // Dependency Injection - needed to share a state between different Steps with a .resources.feature

        loginPage.enterCustomerUsername(username);

        loginPage.enterCustomerPassword(password);

        log.info("Entered customers login details");
    }

    @Then("^I click Log in$")
    public void i_click_log_in() {

        loginPage.customerLogin();

        log.info("Clicked on login button");
    }

    @And("^I should be taken to the Overview page$")
    public void i_should_be_taken_to_the_overview_page() {

        waitExplicitlyForExpectedConditions(30,".title");

        String actualUserFullName = loginPage.getTheUserFullName().toString();

        log.info(actualUserFullName);

        Assert.assertTrue("The names are different please check and re-try again.",
                loginPage.getTheUserFullName().contains(baseUtil.userFullName));

        System.out.println(baseUtil.userFullName);

        loginPage.isAccountPageTitleDisplayed();
        log.info("Validating customers homepage");

        loginPage.customerLogout();

        log.info("Logging out");
    }

    @After("@Test2")
    public void tearDown(Scenario scenario) {

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
