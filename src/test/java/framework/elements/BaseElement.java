package framework.elements;

import framework.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class BaseElement {
    protected WebElement element;
    protected List<WebElement> elements;
    private By by;
    private String name;
    private WebDriver wait;

    public BaseElement(By by){
        this.by = by;
    }

    public void click(){
        isElementPresent();
        element.click();
    }

    public void clickAndWait(){
        click();
        Browser.waitForPageToLoad();
    }

    public BaseElement(By by, String name){
        this.by = by;
        this.name = name;
    }

    public WebElement getElement(){
        isElementPresent();
        return element;
    }

    public boolean isElementPresent(){
        try{
            Browser.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(Browser.getTimeoutForCondition()), TimeUnit.SECONDS);
            element = Browser.getDriver().findElement(by);
            System.out.println(getElementType() + ": " + by + " - is present");
            return element.isDisplayed();
        } catch (NoSuchElementException e){
            System.out.println(getElement() + ": " + by + " - is present. Exception - NoSuchElementException");
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }
        return false;
    }

    protected abstract String getElementType();

    public void clickViaJS() {
        isElementPresent();
        if (Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].style.border='3px solid blue'", element);
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].click();", element);
        }
    }

    public void moveToElement(){
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).perform();
    }

    public void moveAndClickByAction(){
        isElementPresent();
        Actions actions = new Actions(Browser.getDriver());
        actions.moveToElement(element).click().perform();
    }

    public void sendKeys(String sendKeys) {
        isElementPresent();
        getElement().sendKeys(sendKeys);
    }

    public void scrollToElementViaJS(){
        isElementPresent();
        if (Browser.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) Browser.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        }
    }

}
