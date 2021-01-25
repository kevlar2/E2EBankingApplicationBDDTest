package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferFundsPage {

    WebDriver driver;

    public TransferFundsPage(WebDriver driver){
        this.driver=driver;
    }

    WebElement transferFunds;


    public TransferFundsPage(){
        super();
    }


}
