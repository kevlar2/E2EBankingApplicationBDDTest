package PageObjects;

import BasePage.BaseActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BillPayPage extends BaseActions {

    public BillPayPage(WebDriver driver) {
        super(driver);
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
        click(billPayPage);
        return new BillPayPage();
    }

    public String validatePageUrl(){
        return getPageCurrentUrl();
    }

    public BillPayPage enterPayeeName(String name){
        enter(payeeName, name);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddress(String address){
        enter(payeeAddress, address);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddressCity(String city){
        enter(payeeAddressCity, city);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddressState(String state){
        enter(payeeAddressState, state);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAddressZipCode(String zipCode){
        enter(payeeAddressZipCode, zipCode);
        return new BillPayPage();
    }

    public BillPayPage enterPayeePhoneNumber(String phoneNumber){
        enter(payeePhoneNumber, phoneNumber);
        return new BillPayPage();
    }

    public BillPayPage enterPayeeAccountNumber(String accountNumber){
        enter(payeeAccountNumber, accountNumber);
        return new BillPayPage();
    }

    public BillPayPage verifyPayeeAccountNumber(String accountNumber){
        enter(verifyAccount, accountNumber);
        return new BillPayPage();
    }

    public BillPayPage enterAmount(String amountValue){
        enter(amount, amountValue);
        return new BillPayPage();
    }

    public BillPayPage selectFromAccountNumber(){
        click(fromAccountId);
        enter(fromAccountId, (new StringBuilder().append(String.valueOf(Keys.ARROW_DOWN))
                .append(String.valueOf(Keys.ENTER)).toString()));
        return new BillPayPage();
    }

    public BillPayPage clickSendPayment(){
        click(sendPayment);
        return new BillPayPage();
    }

    public String getBillPaymentConfirmationMessage(){
        return getText(billPaymentConfirmationMessage);
    }

    public boolean isBillPaymentConfirmationMessageDisplayed(){
        return isDisplayed(billPaymentConfirmationMessage);
    }

    public boolean isBillPaymentConfirmationAmountDisplayed(){
        return isDisplayed(billPaymentConfirmationAmount);
    }

    public boolean isBillPaymentConfirmationFromAccountNumberDisplayed(){
        return isDisplayed(billPaymentConfirmationFromAccountNumber);
    }

    public boolean isBillPaymentAccountActivityMessage(){
        return isDisplayed(billPaymentAccountActivityMessage);
    }

    public BillPayPage userLogsOut(){
        click(logOut);
        return new BillPayPage();
    }











}
