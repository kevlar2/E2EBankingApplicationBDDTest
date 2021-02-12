package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPage {

    private WebDriver driver;


    public TransferFundsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Transfer Funds')]") private WebElement transferFundsPage;
    @FindBy(css = "input#amount") private WebElement amount;
    @FindBy(css = "select#fromAccountId") private WebElement fromAccountId;
    @FindBy(css = "select#toAccountId") private WebElement toAccountId;
    @FindBy(css = "input[value$='Transfer']") private WebElement transfer;
    @FindBy(css = "h1[class='title']") private WebElement pageTitle; // Transfer Complete!
    @FindBy(xpath = "//div[@id='rightPanel']//p[1]") private WebElement transferConfirmationMessage;
    //$1000.00 has been transferred from account #15564 to account #15564.
    @FindBy(css = "span#amount") private WebElement transferredAmount;
    @FindBy(css = "span#fromAccountId") private WebElement transferFromAccountId;
    @FindBy(css = "span#toAccountId") private WebElement transferToAccountId;
    @FindBy(xpath = "//p[text()='See Account Activity for more details.']") private WebElement accountActivity;
    @FindBy(linkText = "Log Out") private WebElement logOut;

    public TransferFundsPage(){
        super();
    }

    public TransferFundsPage userLogin(String username, String password){
        LoginPage userLogin = new LoginPage(driver);
        userLogin.enterCustomerUsername(username);
        userLogin.enterCustomerPassword(password);
        userLogin.customerLogin();
        return new TransferFundsPage();
    }

    public TransferFundsPage getTransferFundsPage(){
        transferFundsPage.click();
        return new TransferFundsPage();
    }

    public TransferFundsPage enterAmount(String amountToEnter){
        amount.sendKeys(amountToEnter);
        return new TransferFundsPage();
    }

    public String getAmountEntered(){
        return amount.getText().toString();
    }

    public TransferFundsPage selectFromAccount(){
        fromAccountId.click();
        fromAccountId.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
        return new TransferFundsPage();
    }

    public String getFromAccountID(){
        return fromAccountId.getText();
    }

    public TransferFundsPage selectToAccount(){
        toAccountId.click();
        toAccountId.sendKeys(Keys.ENTER);
        return new TransferFundsPage();
    }

    public String getToAccountId(){
        return toAccountId.getText();
    }

    public TransferFundsPage processTransfer(){
        transfer.click();
        return new TransferFundsPage();
    }

    public boolean isTransferConfirmationDisplayed(){
        return transferConfirmationMessage.isDisplayed();
    }

    public boolean isTransferredAmountDisplayed(){
        return transferredAmount.isDisplayed();
    }

    public boolean isTransferFromAccountIdDisplayed(){
        return transferFromAccountId.isDisplayed();
    }

    public boolean isTransferToAccountIdDisplayed(){
        return transferToAccountId.isDisplayed();
    }

    public boolean isAccountActivityTextDisplayed(){
        return accountActivity.isDisplayed();
    }

    public TransferFundsPage userLogsOut(){
        logOut.click();
        return new TransferFundsPage();
    }





}
