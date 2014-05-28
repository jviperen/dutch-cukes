package cukes.dutch.pageobjects.google;

import cukes.dutch.pageobjects.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Google_PageObject extends BasePage {

	public Google_PageObject(WebDriver webDriver) {
		super(webDriver);
	}

     private final static Logger LOGGER = Logger.getLogger(Google_PageObject.class .getName());

    private By zoek_veld = By.id("gbqfq");
    private By eerste_zoek_resultaat = By.xpath("//*[@id='rso']//div[1]/cite");

    public void log_setup_showcase() {
        LOGGER.log(Level.INFO, "Background is executed");
    }

    public void zoek_met_criteria(String zoekCriteria) {
        getWebDriver().findElement(zoek_veld).sendKeys(zoekCriteria);
    }

    public void assert_eerste_zoek_resultaat(String eerste_positie){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(eerste_positie,
                getWebDriver().findElement(eerste_zoek_resultaat).getText());
    }
}
