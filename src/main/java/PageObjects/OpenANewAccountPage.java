package PageObjects;

import BasePage.BaseActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenANewAccountPage extends BaseActions {

    public OpenANewAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Open New Account')]") private WebElement openANewAccountPage;
    @FindBy(css = ".title") private WebElement pageTitle;
    @FindBy(css = "select[id='type']") private WebElement accountTypeToSelect;
    @FindBy(css = "select[id='fromAccountId']") WebElement accountToTransferFrom;
    @FindBy(css = "input[value*='Open New Account']") WebElement openNewAccount;
    @FindBy(css = "h1[class='title']") WebElement accountOpenedPageTitle; // Account Opened!
    @FindBy(xpath = "//p[contains(text(),'Congratulations, your account is now open.')]")
    WebElement accountConfirmationMessage;
    @FindBy(css = "#newAccountId") WebElement newAccountID;
    @FindBy(xpath = "//td[@id='accountId']") WebElement accountNumber;
    @FindBy(css = "#accountType") WebElement accountType;
    @FindBy(css = "#balance") WebElement balance;
    @FindBy(css = "#availableBalance") WebElement availableBalance;
    @FindBy(css = "select[id$='month']") WebElement accountMonth; //#month
    @FindBy(css = "#transactionType") WebElement transactionType;
    @FindBy(xpath = "//a[.='Funds Transfer Received']") WebElement transaction;
    @FindBy(css = "input[value='Go']") WebElement go;


    public String pageUrl = "https://parabank.parasoft.com/parabank/openaccount.htm";
    public String accountConfirmationMessageText =
            "Congratulations, your account is now open.";

    public OpenANewAccountPage(){
        super();
    }

    public OpenANewAccountPage getOpenANewAccountForm(){
        click(openANewAccountPage);
        return new OpenANewAccountPage();
    }

    public String getUrl(){
        return getPageCurrentUrl().toString();
    }

    public String getPageTitle(){
        return getText(pageTitle).toString();
    }

    public OpenANewAccountPage selectAccountType(String accountType){
        selectElementByVisibleText(accountTypeToSelect,accountType);
        return new OpenANewAccountPage();
    }

    public OpenANewAccountPage selectAccountToTransferFrom(){
        click(accountToTransferFrom);
        enter(accountToTransferFrom, String.valueOf(Keys.ENTER));
        return new OpenANewAccountPage();
    }

    public OpenANewAccountPage clickOpenNewAccount(){
        click(openNewAccount);
        return new OpenANewAccountPage();
    }

    public String validateOpenedAccountPageTitle(){
        // Account Opened!
        return getText(accountOpenedPageTitle).toString();
    }

    public String getAccountConfirmationMessage(){
        return getText(accountConfirmationMessage);
    }

    public OpenANewAccountPage getAccountDetailsPage(){
        click(newAccountID);
        return new OpenANewAccountPage();
    }

    public String getNewAccountID(){
        return getText(newAccountID);
    }

    public String getAccountNumber(){
        return getText(accountNumber);
    }

    public String getAccountType(){
        return getText(accountType);
    }

    public String getBalance(){
        return getText(balance);
    } // check balance and availableBalance are the same value

    public String getAvailableBalance(){
        return getText(availableBalance);
    }

    public OpenANewAccountPage selectAccountMonth(String month) throws InterruptedException {
        selectElementByVisibleText(accountMonth,month);
        return new OpenANewAccountPage();
    }

    public OpenANewAccountPage selectTransactionType(String transactionType){
        selectElementByVisibleText(this.transactionType, transactionType);
        return new OpenANewAccountPage();
    }

    public String conformTransactionOnAccount(){
        return getText(transaction);
    }

    public OpenANewAccountPage clickOnGo(){
        click(go);
        return new OpenANewAccountPage();
    }

}
