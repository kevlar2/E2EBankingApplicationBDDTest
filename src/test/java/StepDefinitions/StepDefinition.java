package StepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.base;

public class StepDefinition extends base {

    public WebDriver driver;

    @Given("^I am in the login page of the para bank web application$")
    public void i_am_in_the_login_page_of_the_para_bank_web_application() throws Throwable {
        driver = initialiseDriver();
        driver.get(prop.getProperty("url"));
    }

    @When("^I enter a valid username and password$")
    public void i_enter_a_valid_username_and_password() throws Throwable {
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("input[name$='username']")).sendKeys("tautester");
        driver.findElement(By.cssSelector("input[name$='password']")).sendKeys("password");
    }

    @Then("^I click Log in$")
    public void i_click_log_in() throws Throwable {
        Thread.sleep(1500);
        driver.findElement(By.cssSelector("input[name$='username']")).submit();
    }

    @And("^I should be taken to the Overview page$")
    public void i_should_be_taken_to_the_overview_page() throws Throwable {
        Thread.sleep(2500);
        driver.findElement(By.cssSelector(".title")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();
        driver.close();
    }

}
