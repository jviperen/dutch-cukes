package cukes.dutch.stepdefs.Rabo;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cukes.dutch.driver.SharedDriver;
import cukes.dutch.pageobjects.BasePage;
import cukes.dutch.pageobjects.rabobank.Rabobank_PageObject;

public class RabobankHypDossier_StepDef {

	private Rabobank_PageObject frontPage;
    private BasePage basePage;

    public RabobankHypDossier_StepDef(SharedDriver webDriver) {
        frontPage = new Rabobank_PageObject(webDriver);
        basePage = new BasePage(webDriver);
    }

    @Dan("^kan de gebruiker een uitgebreide berekening maken$")
    public void kan_de_gebruiker_een_uitgebreide_berekening_maken() throws Throwable {
    	frontPage.assertUrlHypotheken();
        frontPage.assertThatUitgebreideBerekeningKnopIsVisible();
    }

    @Als("^de gebruiker navigeert naar het Rabobank HypotheekDossier$")
    public void de_gebruiker_navigeert_naar_het_Rabobank_HypotheekDossier() throws Throwable {
        basePage.navigateTo("Hypotheken");
    }

}
