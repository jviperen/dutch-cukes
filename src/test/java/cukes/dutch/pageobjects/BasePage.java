package cukes.dutch.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BasePage {
	private WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver(){
    	return webDriver;
    }

	public void navigateTo(String linkText) {
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


}
