package AbstractComponents;

import org.openqa.selenium.WebElement;

public abstract class AbstractComponents {

    //public abstract WebElement findElement(By locator);

    public abstract void click(WebElement element);

    public abstract void submit(WebElement element);

    public abstract void enter(WebElement element, String textToEnter);

    public abstract void refreshPage();

    public abstract String getText(WebElement element);

    public abstract boolean isSelected(WebElement element);

    public abstract boolean isDisplayed(WebElement element);

    public abstract void jsExecutorClick(String scriptToExecute);

    public abstract String getPageCurrentUrl();

    public abstract void selectElementByVisibleText(WebElement element, String textToSelect);

    public abstract void selectElementByValue(WebElement element, String valueToSelect);

    public abstract void selectElementByValue(WebElement element, int indexToSelect);



}
