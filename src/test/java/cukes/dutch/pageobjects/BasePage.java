package cukes.dutch.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;


public class BasePage {
	private WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver(){
    	return webDriver;
    }

	public void navigateTo(String linkText) {

        webDriver.getPageSource().contains(linkText);
        webDriver.findElement(By.linkText(linkText)).click();
    }

    public void assertElementPresent(By element){
        Assert.assertTrue(getWebDriver().findElement(element).isDisplayed());
    }

    public void assertElementPresent(WebElement element){
    	Assert.assertTrue(element.isDisplayed());
    }

    public void assertCurrentUrl(String urlExpected) {
        dirtySleep(1000);
        Assert.assertEquals(urlExpected, getWebDriver().getCurrentUrl());
    }

    private void dirtySleep(int millis){
        // EVIL METHOD (through UI this can be horrible. What if somebodt desides to set millis to 1000000)
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnElement(By element){
        waitForElementPresent(element);
    	webDriver.findElement(element).click();
    }

    public void clickOnElement(WebElement element) {
        waitForElementPresent(element);
        element.click();
    }

    public void clearFieldFromElement(By element){
    	webDriver.findElement(element).clear();
    }

    public String getTextFromElement(By element){
        waitForElementPresent(element);
    	return webDriver.findElement(element).getText();
    }

    public String getValueFromElement(By element, String attributeValue){
    	return webDriver.findElement(element).getAttribute(attributeValue);
    }

    public void waitForElementPresent(By by){
        final int seconds_to_wait = 10;
        WebDriverWait wait = new WebDriverWait(webDriver, seconds_to_wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementPresent(WebElement element){
        final int seconds_to_wait = 10;
        WebDriverWait wait = new WebDriverWait(webDriver, seconds_to_wait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void typeKeysIntoElement(By element, String characters){
        webDriver.findElement(element).sendKeys(characters);
    }

    public void openUrl(String url) {
        webDriver.get(url);
    }

    public WebElement getElementBy(By element_locator) {
        return getWebDriver().findElement(element_locator);

    }


}
