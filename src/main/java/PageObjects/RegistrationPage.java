package PageObjects;

import BasePage.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseActions {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Register") WebElement registrationForm;
    @FindBy(xpath="//input[@id='customer.firstName']") WebElement customerFirstName;
    @FindBy(xpath="//input[@id='customer.lastName']") WebElement customerLastName;
    @FindBy(xpath="//input[@id='customer.address.street']") WebElement streetAddress;
    @FindBy(xpath="//input[@id='customer.address.city']") WebElement addressCity;
    @FindBy(xpath="//input[@id='customer.address.state']") WebElement addressState;
    @FindBy(xpath="//input[@id='customer.address.zipCode']") WebElement addressZipcode;
    @FindBy(xpath="//input[@id='customer.ssn']") WebElement customerSsn; // ssn = Social Security Number
    @FindBy(xpath="//input[@id='customer.username']") WebElement customerUsername;
    @FindBy(xpath="//input[@id='customer.password']") WebElement customerPassword;
    @FindBy(xpath="//input[@id='repeatedPassword']") WebElement confirmPassword;
    @FindBy(css = "span[id*='customer.username.errors']") WebElement customerUsernameError;
    @FindBy(xpath="//input[@value='Register']") WebElement submitButton;
    @FindBy(css = ".title") WebElement accountPageTitle;
    @FindBy(xpath = "//p[contains(text(),'Your account was created successfully. You are now logged in.')]")
    WebElement customerWelcomeText;
    @FindBy(linkText = "Log Out") WebElement logOut;


    public RegistrationPage() {
        super();
    }

    public RegistrationPage getRegistrationForm(){
        click(registrationForm);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersFirstName(String firstName){
        enter(customerFirstName, firstName);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersLastName(String lastname){
        enter(customerLastName, lastname);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersFullAddress(String street, String city, String state, String zipCode){

        enter(streetAddress, street);

        enter(addressCity, city);

        enter(addressState, state);

        enter(addressZipcode, zipCode);

        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersSocialSecurityNumber(String ssn){
        enter(customerSsn, ssn);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersUsername(String username){
        enter(customerUsername, username);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersPassword(String password){
        enter(customerPassword, password);
        return new RegistrationPage();
    }

    public RegistrationPage confirmCustomersPassword(String password){
        enter(confirmPassword, password);
        return new RegistrationPage();
    }

    public String getCustomerUsernameError(){
        return getText(customerUsernameError).toString();
    }

    public boolean isCustomerUsernameErrorDisplayed(){
        return isDisplayed(customerUsernameError);
    }

    public void enterCustomersFullName(String customersFirstName, String customersLastName){

        enterCustomersFirstName(customersFirstName);

        enterCustomersLastName(customersLastName);
    }

    public RegistrationPage completeRegistration(){
        click(submitButton);
        return new RegistrationPage();
    }

    public RegistrationPage validateAccountPageAfterRegistration(){
        isDisplayed(accountPageTitle);
        return new RegistrationPage();
    }

    public String getCustomerWelcomeText(){
        return getText(customerWelcomeText).toString();
    }

    public boolean isCustomersWelcomeTextDisplayed(){
        return isDisplayed(customerWelcomeText);
    }

    public RegistrationPage loginOut(){
        click(logOut);
        return new RegistrationPage();
    }


}
