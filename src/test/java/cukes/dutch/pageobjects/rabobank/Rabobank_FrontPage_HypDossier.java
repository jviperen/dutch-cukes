package cukes.dutch.pageobjects.rabobank;

import cukes.dutch.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Rabobank_FrontPage_HypDossier extends BasePage {

    public Rabobank_FrontPage_HypDossier(WebDriver webDriver) {
        super(webDriver);
    }

    private String persoonlijk_hypotheek_dossier_id = "moa-choice-kbg-submit";
    private String kbg_starter_id = "moa-choice-kbg-no-koopwoning";


    public void kies_kbg_starter() {
        clickOnElement(By.id(kbg_starter_id));
        clickOnElement(By.id(persoonlijk_hypotheek_dossier_id));
    }


}
