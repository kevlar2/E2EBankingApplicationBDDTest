package PageObjects;

import BasePage.BaseActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginPage extends BaseActions {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name$='username']") private WebElement customerUsername;
    @FindBy(css = "input[name$='password']") private WebElement customerPassword;
    @FindBy(css = "input[value='Log In']") private WebElement Login;
    @FindBy(css = ".smallText") private WebElement accountUserFullName;
    @FindBy(css = ".title") private WebElement accountPageTitle;
    @FindBy(linkText = "Log Out") private WebElement logOut;

    public LoginPage(){
        super();
    }

    public LoginPage enterCustomerUsername(String userName){
        enter(customerUsername,userName);
        return new LoginPage();
    }

    public LoginPage enterCustomerPassword(String passWord){
        enter(customerPassword, passWord);
        return new LoginPage();
    }

    public LoginPage customerLogin(){
        submit(Login);
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

        return getText(accountUserFullName).toString();
    }

    public LoginPage isAccountPageTitleDisplayed(){
        isDisplayed(accountPageTitle);
        return new LoginPage();
    }

    public LoginPage customerLogout(){
        click(logOut);
        return new LoginPage();
    }

}
