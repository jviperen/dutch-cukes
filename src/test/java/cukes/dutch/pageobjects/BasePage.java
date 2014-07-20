package cukes.dutch.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.linkText(linkText)).click();
    }

    public void assertElementPresent(By element){
        Assert.assertTrue(getWebDriver().findElement(element).isDisplayed());
    }

    public void assertElementPresent(WebElement element){
    	Assert.assertTrue(element.isDisplayed());
    }

    public void assertCurrentUrl(String urlExpected){
    	Assert.assertEquals(urlExpected, getWebDriver().getCurrentUrl());
    }

    public void clickOnElement(By element){
    	webDriver.findElement(element).click();
    }

    public void clearFieldFromElement(By element){
    	webDriver.findElement(element).clear();
    }

    public String getTextFromElement(By element){
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
