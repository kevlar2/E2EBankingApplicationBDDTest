package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage {

    WebDriver driver;

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
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
        requestLoanPage.click();

        return new RequestLoanPage();
    }

    public String validatePageTitle(){
        return pageTitle.getText().toString(); // expected value = "Apply for a Loan"
    }

    public RequestLoanPage enterLoanAmount(String loanAmount){
        this.loanAmount.sendKeys(loanAmount);
        return new RequestLoanPage();
    }

    public RequestLoanPage enterDownPaymentAmount(String downPayment){
        this.downPayment.sendKeys(downPayment);
        return new RequestLoanPage();
    }

    public RequestLoanPage selectFromAccount(){
        fromAccount.click();
        fromAccount.sendKeys(Keys.ENTER);

        return new RequestLoanPage();
    }

    public RequestLoanPage clickApplyNow(){
        applyNow.click();
        return new RequestLoanPage();
    }

    public String getLoanProviderName(){
        return loanProviderName.getText();
    }

    public String getLoanStatus(){

        return loanStatus.getText();
    }

    public boolean isResponseDateDisplayed(){

        return date.isDisplayed();
    }

    public String getLoanConfirmationMessage(){
        return loanConfirmationMessage.getText();
    }

    public String getLoanDisapprovalMessage(){
       return loanDisapprovalMessage.getText();
    }

    public boolean isNewAccountIdDisplayed(){

        return activeAccountId.isDisplayed();
    }






}
