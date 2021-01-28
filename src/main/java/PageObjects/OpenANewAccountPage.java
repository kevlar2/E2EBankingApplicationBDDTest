package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenANewAccountPage {

    public WebDriver driver;

    // Constructor
    public OpenANewAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy() WebElement openANewAccountPage;


    public OpenANewAccountPage(){
        super();
    }

}
