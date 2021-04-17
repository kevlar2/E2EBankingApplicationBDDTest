package BasePage;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseActions extends AbstractComponents {

    protected WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public BaseActions(){
        super();
    }

    /*public WebElement findElement(By locator){
        return driver.findElement(locator);
    } */

    @Override
    public void click(WebElement element){
        element.click();
    }

    @Override
    public void submit(WebElement element) {
        element.submit();
    }

    @Override
    public void enter(WebElement element, String textToEnter){
        element.sendKeys(textToEnter);
    }

    @Override
    public void refreshPage(){
        driver.navigate().refresh();
    }

    @Override
    public String getText(WebElement element){
        return element.getText();
    }

    @Override
    public boolean isSelected(WebElement element){
        try {
            return element.isSelected();
        }catch(org.openqa.selenium.NoSuchElementException exception){
            return false;
        }

    }

    @Override
    public boolean isDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception){
            return false;
        }

    }

    @Override
    public void jsExecutorClick(String scriptToExecute){
        ((JavascriptExecutor) driver).executeScript(scriptToExecute);
    }

    @Override
    public String getPageCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public void selectElementByVisibleText(WebElement element, String optionToSelect) {
        Select select = new Select(element);
        select.selectByVisibleText(optionToSelect);
    }

    @Override
    public void selectElementByValue(WebElement element, String valueToSelect) {
        Select select = new Select(element);
        select.selectByValue(valueToSelect);
    }

    @Override
    public void selectElementByValue(WebElement element, int indexToSelect) {
        Select select = new Select(element);
        select.selectByIndex(indexToSelect);
    }

}
