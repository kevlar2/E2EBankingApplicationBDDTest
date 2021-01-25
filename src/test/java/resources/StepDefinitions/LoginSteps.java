package resources.StepDefinitions;

import PageObjects.LoginPage;
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

public class LoginSteps extends base {

    public WebDriver driver;

    private final base baseUtil;

    public LoginSteps(base util){

        this.baseUtil =util;
    }

    LoginPage loginPage;

    @Before("@Test2")
    public void initialiseWebdriver() throws IOException {

        driver = initialiseDriver();
        driver.get(prop.getProperty("url"));
    }

    @Given("^I am in the login page of the para bank web application$")
    public void i_am_in_the_login_page_of_the_para_bank_web_application() throws Throwable {

        loginPage = new LoginPage(driver);
    }

    @When("^I enter a valid (.+) and (.+) with (.+)$")
    public void i_enter_a_valid_username_and_password(String username, String password, String userFullName) throws Throwable {

        baseUtil.userFullName = userFullName; // Dependency Injection - needed to share a state between different Steps with a .resources.feature

        loginPage.enterCustomerUsername(username);

        loginPage.enterCustomerPassword(password);
    }

    @Then("^I click Log in$")
    public void i_click_log_in() throws Throwable {

        loginPage.customerLogin();
    }

    @And("^I should be taken to the Overview page$")
    public void i_should_be_taken_to_the_overview_page() throws Throwable {

        waitExplicitlyForExpectedConditions(30,".title");

        String actualUserFullName = loginPage.getTheUserFullName().toString();

        System.out.println(actualUserFullName);

        Assert.assertTrue("The names are different please check and re-try again.",
                loginPage.getTheUserFullName().contains(baseUtil.userFullName));

        System.out.println(baseUtil.userFullName);

        loginPage.isAccountPageTitleDisplayed();

        loginPage.customerLogout();
    }

    @After("@Test2")
    public void tearDown(){
        driver.close();
    }

}
