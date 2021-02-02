package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenANewAccountPage {

    public WebDriver driver;

    // Constructor
    public OpenANewAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Open New Account')]") WebElement openANewAccountPage;
    @FindBy(css = ".title") WebElement pageTitle;
    @FindBy(css = "select[id='type']") WebElement accountTypeToSelect;
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
        openANewAccountPage.click();
        return new OpenANewAccountPage();
    }

    public String getUrl(){
        return driver.getCurrentUrl().toString();
    }

    public String getPageTitle(){
        return pageTitle.getText().toString();
    }

    public OpenANewAccountPage selectAccountType(String accountType){
        Select select = new Select(accountTypeToSelect);
        select.selectByVisibleText(accountType);
        return new OpenANewAccountPage();
    }

    public OpenANewAccountPage selectAccountToTransferFrom(){
        accountToTransferFrom.click();
        accountToTransferFrom.sendKeys(Keys.ENTER);
        return new OpenANewAccountPage();
    }

    public OpenANewAccountPage clickOpenNewAccount(){
        openNewAccount.click();
        return new OpenANewAccountPage();
    }

    public String validateOpenedAccountPageTitle(){
        // Account Opened!
        return accountOpenedPageTitle.getText();
    }

    public String getAccountConfirmationMessage(){
        return accountConfirmationMessage.getText();
    }

    public OpenANewAccountPage getAccountDetailsPage(){
        newAccountID.click();
        return new OpenANewAccountPage();
    }

    public String getNewAccountID(){
        return newAccountID.getText();
    }

    public String getAccountNumber(){
        return accountNumber.getText();
    }

    public String getAccountType(){
        return accountType.getText();
    }

    public String getBalance(){
        return balance.getText();
    } // check balance and availableBalance are the same value

    public String getAvailableBalance(){
        return availableBalance.getText();
    }

    public OpenANewAccountPage selectAccountMonth(String month) throws InterruptedException {
        Select select = new Select(accountMonth);
        select.selectByValue(month);

        return new OpenANewAccountPage();
    }

    public OpenANewAccountPage selectTransactionType(String transactionType){
        Select select = new Select(this.transactionType);
        select.selectByValue(transactionType);
        return new OpenANewAccountPage();
    }

    public OpenANewAccountPage clickOnGo(){
        go.click();
        return new OpenANewAccountPage();
    }

}
