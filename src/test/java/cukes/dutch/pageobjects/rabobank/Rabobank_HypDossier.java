package cukes.dutch.pageobjects.rabobank;

import cukes.dutch.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Rabobank_HypDossier extends BasePage {

    public Rabobank_HypDossier(WebDriver webDriver) {
        super(webDriver);
    }

    // LIST ALL NEEDED ELEMENTS NEEDED FOR USER JOURNEY
    // OP basis van inkomen en gewenst huis NHG niet mogelijk. misschien zelfs interfaces maken voor scheiding van elementen

    private String nhg_status_id = "moa-nhg-title";
    private String persoonlijke_berekening_css = "#moa-blind-persoonlijkeberekening > span";
    private String intro_text_id = "moa-intro-introtext";
    WebElement persoonlijke_berekening;
    WebElement nhg_status_element;


    // methods

    public void maak_persoonlijke_berekening() {
        waitForElementPresent(By.id(intro_text_id));
        persoonlijke_berekening = getElementBy(By.cssSelector(persoonlijke_berekening_css));
        clickOnElement(persoonlijke_berekening);
    }

    public void what_is_status_nhg() {
//        String whatIsText = getTextFromElement(By.id(nhg_status_id));
//        System.out.println("NHG Status is nu : " + nhg_status_element.getText());
    }
}


