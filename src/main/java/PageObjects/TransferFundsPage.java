package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPage {

    public WebDriver driver;

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
    @FindBy(xpath = "//p[contains(.,'$1000.00 has been transferred from account #15564 to account #15564.')]")
    private WebElement transferConfirmationMessage; //$1000.00 has been transferred from account #15564 to account #15564.
    @FindBy(css = "span#amount") private WebElement transferredAmount;
    @FindBy(css = "span#fromAccountId") private WebElement transferFromAccountId;
    @FindBy(css = "span#toAccountId") private WebElement transferToAccountId;
    @FindBy(xpath = "//p[text()='See Account Activity for more details.']") private WebElement accountActivity;
    @FindBy(linkText = "Log Out") private WebElement logOut;

    public TransferFundsPage(){
        super();
    }

    public TransferFundsPage userLogin(String username, String password){
        LoginPage userLogin = new LoginPage();
        userLogin.enterCustomerUsername(username);
        userLogin.enterCustomerPassword(password);
        userLogin.customerLogin();
        return new TransferFundsPage();
    }

    public TransferFundsPage getTransferFundsPage(){
        transferFundsPage.click();
        return new TransferFundsPage();
    }





}
