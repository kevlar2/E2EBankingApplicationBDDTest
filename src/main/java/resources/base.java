package resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {

    public WebDriver driver;
    public Properties prop;
    private static Logger log = LogManager.getLogger(base.class.getName());

    // Dependency Injection - needed to share a state between different Steps with a .resources.feature
    // Maven dependency for cucumber-picocontainer is needed in the pom.xml

    public String userFullName;


    public WebDriver initialiseDriver() throws IOException {

        // Creates the property object
        prop = new Properties();

        // This allows for you to read the file and it requires file path
        FileInputStream fips = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
        prop.load(fips);

        // Maven properties and Jenkins parameterised job
        String browserName =System.getProperty("browser");

        // Enables you to choose browser, depending on request or choice. this can be passed via data.properties
        browserName =prop.getProperty("browser");

        switch (browserName){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe");
                driver = new ChromeDriver();
                log.info("Starting chrome browser");
                break;
            case "headless":
                System.setProperty("wbdriver.chrome.driver", System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                log.info("Starting chrome browser in headless mode");
                break;
            case "firefox":
                System.setProperty("wbdriver.chrome.driver", System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe");
                driver = new FirefoxDriver();
                log.info("Starting firefox browser");
                break;
            case "ie":
                System.setProperty("wbdriver.chrome.driver", System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe");
                driver = new InternetExplorerDriver();
                log.info("Starting ie browser");
                break;
            case "microsoft-edge":
                System.setProperty("wbdriver.chrome.driver", System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe");
                driver = new EdgeDriver();
                log.info("Starting microsoft-edge browser");
                break;

            default:
                log.info("Invalid browser requested");
        }

        // Simple webdriver Set-up
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public void waitExplicitlyForExpectedConditions(int timeoutInSeconds, String locatorElementForCSS){
        WebDriverWait wait= new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorElementForCSS)));
    }

    public void waitExplicitlyForExpectedConditionsXpath(int timeoutInSeconds, String locatorElementForXpath){
        WebDriverWait wait= new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorElementForXpath)));
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        // Path to store screenshot \\reports\\ -> folder
        String pathName = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";

        // Takes the screenshot
        TakesScreenshot ts =(TakesScreenshot) driver;

        // Creates a file and send the to the assigned destination
        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE),new File(pathName));

        return pathName;

    }

    public byte[] getScreenshotWithoutPath(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String monthSelector(int month) {
        switch(month){
            case 0: return "January";
            case 1: return "February";
            case 2: return "March";
            case 3: return "April";
            case 4: return "May";
            case 5: return "June";
            case 6: return "July";
            case 7: return "August";
            case 8: return "September";
            case 9: return "October";
            case 10: return "November";
            case 11: return "December";
            default:
                return "Unknown month";
        }
    }


}
