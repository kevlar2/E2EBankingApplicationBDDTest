package PageObjects;

import BasePage.BaseActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage extends BaseActions {

    public RequestLoanPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Request Loan") WebElement requestLoanPage;
    @FindBy(css = ".title") WebElement pageTitle;
    @FindBy(css = "input[id$='amount']") WebElement loanAmount;
    @FindBy(css = "input[id$='downPayment']") WebElement downPayment;
    @FindBy(css = "select[id$='fromAccountId']")WebElement fromAccount;
    @FindBy(css = "input[value$='Apply Now']") WebElement applyNow;
    @FindBy(css = "#loanProviderName") WebElement loanProviderName;
    @FindBy(css = "#loanStatus") WebElement loanStatus;
    @FindBy(css = "#responseDate") WebElement date;
    @FindBy(xpath = "//p[.='Congratulations, your loan has been approved.']") WebElement loanConfirmationMessage;
    @FindBy(css = "p[class='error ng-scope']") WebElement loanDisapprovalMessage;
    @FindBy(css = "#newAccountId") WebElement activeAccountId;


    public RequestLoanPage(){
        super();
    }

    public RequestLoanPage getRequestLoanPage(){
        click(requestLoanPage);

        return new RequestLoanPage();
    }

    public String validatePageTitle(){
        return getText(pageTitle).toString(); // expected value = "Apply for a Loan"
    }

    public RequestLoanPage enterLoanAmount(String loanAmount){
        enter(this.loanAmount, loanAmount);
        return new RequestLoanPage();
    }

    public RequestLoanPage enterDownPaymentAmount(String downPayment){
        enter(this.downPayment, downPayment);
        return new RequestLoanPage();
    }

    public RequestLoanPage selectFromAccount(){
        click(fromAccount);
        enter(fromAccount, String.valueOf(Keys.ENTER));

        return new RequestLoanPage();
    }

    public RequestLoanPage clickApplyNow(){
        click(applyNow);
        return new RequestLoanPage();
    }

    public String getLoanProviderName(){
        return getText(loanProviderName);
    }

    public String getLoanStatus(){

        return getText(loanStatus);
    }

    public boolean isResponseDateDisplayed(){

        return isDisplayed(date);
    }

    public String getLoanConfirmationMessage(){
        return getText(loanConfirmationMessage);
    }

    public String getLoanDisapprovalMessage(){
       return getText(loanDisapprovalMessage);
    }

    public boolean isNewAccountIdDisplayed(){

        return isDisplayed(activeAccountId);
    }






}
