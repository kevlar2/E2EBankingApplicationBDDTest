package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BillPayPage {

    private WebDriver driver;

    public BillPayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Bill Pay')]") private WebElement billPayPage;
    @FindBy(css = "input[name$='payee.name']") private WebElement payeeName;
    @FindBy(css = "input[name$='payee.address.street']") private WebElement payeeAddress;
    @FindBy(css = "input[name$='payee.address.city']") private WebElement payeeAddressCity;
    @FindBy(css = "input[name$='payee.address.state']") private WebElement payeeAddressState;
    @FindBy(css = "input[name$='payee.address.zipCode']") private WebElement payeeAddressZipCode;
    @FindBy(css = "input[name$='payee.phoneNumber']") private WebElement payeePhoneNumber;
    @FindBy(css = "input[name$='payee.accountNumber']") private WebElement payeeAccountNumber;
    @FindBy(css = "input[name$='verifyAccount']") private WebElement verifyAccount;
    @FindBy(css = "input[name$='amount']") private WebElement amount;
    @FindBy(css = "select[name$='fromAccountId']") private WebElement fromAccountId;
    @FindBy(css = "input[value$='Send Payment']") private WebElement sendPayment;
    @FindBy(css = "div[ng-show='showResult'] p:nth-child(2)") private WebElement billPaymentConfirmationMessage;
    @FindBy(css = "span[id$='amount']") private WebElement billPaymentConfirmationAmount;
    @FindBy(css = "span[id$='fromAccountId']") private WebElement billPaymentConfirmationFromAccountNumber;
    @FindBy(css = "div[ng-show='showResult'] p:nth-child(3)") private WebElement billPaymentAccountActivityMessage;
    @FindBy(linkText = "Log Out") private WebElement logOut;


    public BillPayPage(){
        super();
    }

    public BillPayPage userLogin(String username, String password){
        LoginPage userLogin = new LoginPage(driver);
        userLogin.enterCustomerUsername(username);
        userLogin.enterCustomerPassword(password);
        userLogin.customerLogin();
        return new BillPayPage();
    }

    public BillPayPage getBillPayPage(){
        billPayPage.click();
        return new BillPayPage();
    }

    public String validatePageUrl(){
        return driver.getCurrentUrl();
    }

    public BillPayPage enterPayeeName(String name){
        payeeName.sendKeys(name);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddress(String address){
        payeeAddress.sendKeys(address);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddressCity(String city){
        payeeAddressCity.sendKeys(city);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddressState(String state){
        payeeAddressState.sendKeys(state);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddressZipCode(String zipCode){
        payeeAddressZipCode.sendKeys(zipCode);
        return new BillPayPage();
    }

    public BillPayPage enterPayeePhoneNumber(String phoneNumber){
        payeePhoneNumber.sendKeys(phoneNumber);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAccountNumber(String accountNumber){
        payeeAccountNumber.sendKeys(accountNumber);
        return new BillPayPage();
    }

    public BillPayPage verifyPayeeAccountNumber(String accountNumber){
        verifyAccount.sendKeys(accountNumber);
        return new BillPayPage();
    }

    public BillPayPage enterAmount(String amountValue){
        amount.sendKeys(amountValue);
        return new BillPayPage();
    }

    public BillPayPage selectFromAccountNumber(){
        fromAccountId.click();
        fromAccountId.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        return new BillPayPage();
    }

    public BillPayPage clickSendPayment(){
        sendPayment.click();
        return new BillPayPage();
    }

    public String getBillPaymentConfirmationMessage(){
        return billPaymentConfirmationMessage.getText();
    }

    public boolean isBillPaymentConfirmationMessageDisplayed(){
        return billPaymentConfirmationMessage.isDisplayed();
    }

    public boolean isBillPaymentConfirmationAmountDisplayed(){
        return billPaymentConfirmationAmount.isDisplayed();
    }

    public boolean isBillPaymentConfirmationFromAccountNumberDisplayed(){
        return billPaymentConfirmationFromAccountNumber.isDisplayed();
    }

    public boolean isBillPaymentAccountActivityMessage(){
        return billPaymentAccountActivityMessage.isDisplayed();
    }

    public BillPayPage userLogsOut(){
        logOut.click();
        return new BillPayPage();
    }











}
