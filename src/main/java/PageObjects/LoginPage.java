package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage {

    public WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name$='username']") WebElement customerUsername;
    @FindBy(css = "input[name$='password']") WebElement customerPassword;
    @FindBy(css = "input[value='Log In']") WebElement Login;
    @FindBy(css = ".smallText") WebElement accountUserFullName;
    @FindBy(css = ".title") WebElement accountPageTitle;
    @FindBy(linkText = "Log Out") WebElement logOut;





    public LoginPage(){
        super();
    }

    public LoginPage enterCustomerUsername(String userName){
        customerUsername.sendKeys(userName);
        return new LoginPage();
    }

    public LoginPage enterCustomerPassword(String passWord){
        customerPassword.sendKeys(passWord);
        return new LoginPage();
    }

    public LoginPage customerLogin(){
        Login.submit();
        return new LoginPage();
    }

    public String getTheUserFullName(){

        //String name = accountUserFullName.getText().toString();
        //List<String> newNameList = Arrays.asList(name.split(" "));

        //List<String> actualFullUserName = new ArrayList<String>();
        //actualFullUserName.add(newNameList.get(1));
        //actualFullUserName.add(newNameList.get(2));
        //actualFullUserName.add(newNameList.get(3));
        //String.join(" ",actualFullUserName);

        return accountUserFullName.getText().toString();
    }

    public LoginPage isAccountPageTitleDisplayed(){
        accountPageTitle.isDisplayed();
        return new LoginPage();
    }

    public LoginPage customerLogout(){
        logOut.click();
        return new LoginPage();
    }

}
