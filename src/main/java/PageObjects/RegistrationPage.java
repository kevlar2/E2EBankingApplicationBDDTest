package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    public WebDriver driver;

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
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
        registrationForm.click();
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersFirstName(String firstName){
        customerFirstName.sendKeys(firstName);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersLastName(String lastname){
        customerLastName.sendKeys(lastname);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersFullAddress(String street, String city, String state, String zipCode){

        streetAddress.sendKeys(street);

        addressCity.sendKeys(city);

        addressState.sendKeys(state);

        addressZipcode.sendKeys(zipCode);

        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersSocialSecurityNumber(String ssn){
        customerSsn.sendKeys(ssn);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersUsername(String username){
        customerUsername.sendKeys(username);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersPassword(String password){
        customerPassword.sendKeys(password);
        return new RegistrationPage();
    }

    public RegistrationPage confirmCustomersPassword(String password){
        confirmPassword.sendKeys(password);
        return new RegistrationPage();
    }

    public String getCustomerUsernameError(){
        return customerUsernameError.getText().toString();
    }

    public boolean isCustomerUsernameErrorDisplayed(){
        return customerUsernameError.isDisplayed();
    }

    public void enterCustomersFullName(String customersFirstName, String customersLastName){

        enterCustomersFirstName(customersFirstName);

        enterCustomersLastName(customersLastName);
    }

    public RegistrationPage completeRegistration(){
        submitButton.click();
        return new RegistrationPage();
    }

    public RegistrationPage validateAccountPageAfterRegistration(){
        accountPageTitle.isDisplayed();
        return new RegistrationPage();
    }

    public String getCustomerWelcomeText(){
        return customerWelcomeText.getText().toString();
    }

    public boolean isCustomersWelcomeTextDisplayed(){
        return customerWelcomeText.isDisplayed();
    }

    public RegistrationPage loginOut(){
        logOut.click();
        return new RegistrationPage();
    }


}
