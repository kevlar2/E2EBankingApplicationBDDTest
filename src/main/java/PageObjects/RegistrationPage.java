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
    @FindBy(xpath="//input[@value='Register']") WebElement submitButton;

    public RegistrationPage() {
        super();
    }


    public WebElement getRegistrationForm(){
        return registrationForm;
    }

    public RegistrationPage enterCustomersFirstName(String firstName){
        customerFirstName.sendKeys(firstName);
        return new RegistrationPage();
    }

    public RegistrationPage enterCustomersLastName(String lastname){
        customerLastName.sendKeys(lastname);
        return new RegistrationPage();
    }

    public void setCustomersFullName(String customersFirstName, String customersLastName){

        enterCustomersFirstName(customersFirstName);

        enterCustomersLastName(customersLastName);
    }

    public void setCustomersAddress(String street, String city, String state, String zipCode){

        streetAddress.sendKeys(street);

        addressCity.sendKeys(city);

        addressState.sendKeys(state);

        addressZipcode.sendKeys(zipCode);

    }

    public WebElement setSocialSecurityNumber(){
        return customerSsn;
    }

    public WebElement setCustomersUsername(){
        return customerUsername;
    }

    public WebElement setCustomersPassword(){
        return customerPassword;
    }

    public WebElement confirmCustomersPassword(){
        return confirmPassword;
    }

    public WebElement completeRegistration(){
        return submitButton;
    }


}
