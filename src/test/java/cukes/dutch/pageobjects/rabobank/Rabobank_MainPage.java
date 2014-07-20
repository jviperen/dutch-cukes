package cukes.dutch.pageobjects.rabobank;

import cukes.dutch.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Rabobank_MainPage extends BasePage {

    public Rabobank_MainPage(WebDriver webDriver) {
        super(webDriver);
    }


    private String knop_uitgebreideBerekening_css_selector = "#lamel1-content > fieldset.results > div:nth-child(4) > div > p > button";
    WebElement element_Uitgebreide_Berekening_Knop;

    public void assertThatUitgebreideBerekeningKnopIsVisible() {
        element_Uitgebreide_Berekening_Knop = getWebDriver().findElement(By.cssSelector(knop_uitgebreideBerekening_css_selector));
        assertElementPresent(element_Uitgebreide_Berekening_Knop);
    }

    public void assertUrlHypotheken() throws InterruptedException {
        final String currentUrlShouldBe = "https://www.rabobank.nl/particulieren/producten/hypotheken/";
        assertCurrentUrl(currentUrlShouldBe);
    }


    public void open_uitgebreide_berekening() {
        element_Uitgebreide_Berekening_Knop = getWebDriver().findElement(By.cssSelector(knop_uitgebreideBerekening_css_selector));
        element_Uitgebreide_Berekening_Knop.click();
    }
}
