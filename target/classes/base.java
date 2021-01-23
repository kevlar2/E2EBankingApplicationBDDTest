package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;

    // Dependency Injection - needed to share a state between different Steps with a .resources.feature
    // Maven dependency for cucumber-picocontainer is needed in the pom.xml
    public String userFullName;


    public WebDriver initialiseDriver() throws IOException {

        // Creates the property object
        prop = new Properties();

        // This allows for you to read the file and it requires file path
        FileInputStream fips = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
        prop.load(fips);

        // Simple webdriver Set-up
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public void waitExplicitlyForExpectedConditions(int timeoutInSeconds, String locatorElementForCSS){
        WebDriverWait wait= new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorElementForCSS)));
    }


}
