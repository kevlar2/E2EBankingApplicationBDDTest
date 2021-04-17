package PageObjects;

import BasePage.BaseActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPage extends BaseActions {

    public TransferFundsPage(WebDriver driver){
        super(driver);
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
        click(transferFundsPage);
        return new TransferFundsPage();
    }

    public TransferFundsPage enterAmount(String amountToEnter){
        enter(amount, amountToEnter);
        return new TransferFundsPage();
    }

    public String getAmountEntered(){
        return getText(amount).toString();
    }

    public TransferFundsPage selectFromAccount(){
        click(fromAccountId);
        enter(fromAccountId, (new StringBuilder().append(String.valueOf(Keys.ARROW_DOWN))
                .append(String.valueOf(Keys.ENTER)).toString()));
        return new TransferFundsPage();
    }

    public String getFromAccountID(){
        return getText(fromAccountId);
    }

    public TransferFundsPage selectToAccount(){
        click(toAccountId);
        enter(toAccountId, String.valueOf(Keys.ENTER));
        return new TransferFundsPage();
    }

    public String getToAccountId(){
        return getText(toAccountId);
    }

    public TransferFundsPage processTransfer(){
        click(transfer);
        return new TransferFundsPage();
    }

    public boolean isTransferConfirmationDisplayed(){
        return isDisplayed(transferConfirmationMessage);
    }

    public boolean isTransferredAmountDisplayed(){
        return isDisplayed(transferredAmount);
    }

    public boolean isTransferFromAccountIdDisplayed(){
        return isDisplayed(transferFromAccountId);
    }

    public boolean isTransferToAccountIdDisplayed(){
        return isDisplayed(transferToAccountId);
    }

    public boolean isAccountActivityTextDisplayed(){
        return isDisplayed(accountActivity);
    }

    public TransferFundsPage userLogsOut(){
        click(logOut);
        return new TransferFundsPage();
    }





}
