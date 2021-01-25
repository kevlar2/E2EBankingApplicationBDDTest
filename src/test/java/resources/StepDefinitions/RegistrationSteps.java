package resources.StepDefinitions;

import PageObjects.RegistrationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import resources.base;

import java.io.IOException;
import java.util.List;

public class RegistrationSteps extends base {

    public WebDriver driver;

    RegistrationPage registrationPage;

    @Before("@Test1")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        registrationPage = new RegistrationPage(driver);
    }

    @Given("^I navigate to para bank web application$")
    public void i_navigate_to_para_bank_web_application() throws Throwable {

        driver.get(prop.getProperty("url"));
    }

    @When("^I click on register link$")
    public void i_click_on_register_link() throws Throwable {

        registrationPage.getRegistrationForm();

    }

    @Then("^I enter my (.+) , (.+) and (.+) ,(.+)$")
    public void i_enter_my(String firstname, String lastname, String username, String password) throws Throwable {

        registrationPage.enterCustomersFullName(firstname, lastname);

        registrationPage.enterCustomersUsername(username);

        registrationPage.enterCustomersPassword(password);

        registrationPage.confirmCustomersPassword(password);

    }

    @And("^I enter my street, city, state, zipcode and security security number$")
    public void i_enter_my_street_city_state_and_zipcode(DataTable table) throws Throwable {

        List<String> addressField = table.asList();

        registrationPage.enterCustomersFullAddress(addressField.get(0), addressField.get(1), addressField.get(2), addressField.get(3) );

        registrationPage.enterCustomersSocialSecurityNumber(addressField.get(4));
    }

    @And("^I click on register button$")
    public void i_click_on_register_button() throws Throwable {

        registrationPage.completeRegistration();

    }

    @Then("^I should be logged in$")
    public void i_should_be_logged_in() throws Throwable {

        waitExplicitlyForExpectedConditions(30,".title");

        registrationPage.validateAccountPageAfterRegistration();

        registrationPage.loginOut();
    }

    @After("@Test1")
    public void tearDown(){
        driver.close();
    }

}
