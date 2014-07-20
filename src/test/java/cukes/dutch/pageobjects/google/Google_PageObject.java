package cukes.dutch.pageobjects.google;

import cukes.dutch.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Google_PageObject extends BasePage {

    public Google_PageObject(WebDriver webDriver) {
        super(webDriver);
    }

    private final static Logger LOGGER = Logger.getLogger(Google_PageObject.class.getName());
    // locators
    private String zoekveld_element_byName = "q";
    // element
    WebElement zoekVeld_element;

    public void log_setup_showcase() {
        LOGGER.log(Level.INFO, "Background is executed with no implementation");
    }

    public void zoek_met_criteria(String zoekCriteria) {
        zoekVeld_element = getWebDriver().findElement(By.name(zoekveld_element_byName));
        zoekVeld_element.isDisplayed();
        zoekVeld_element.sendKeys(zoekCriteria);
        zoekVeld_element.submit();
    }


}
