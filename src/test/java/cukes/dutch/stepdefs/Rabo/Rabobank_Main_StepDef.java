package cukes.dutch.stepdefs.Rabo;

import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cukes.dutch.driver.SharedDriver;
import cukes.dutch.pageobjects.BasePage;
import cukes.dutch.pageobjects.rabobank.Rabobank_MainPage;

public class Rabobank_Main_StepDef {

	private Rabobank_MainPage frontPage;
    private BasePage basePage;

    public Rabobank_Main_StepDef(SharedDriver webDriver) {
        frontPage = new Rabobank_MainPage(webDriver);
        basePage = new BasePage(webDriver);
    }

    @Als("^de gebruiker navigeert naar het Rabobank HypotheekDossier$")
    public void de_gebruiker_navigeert_naar_het_Rabobank_HypotheekDossier() throws Throwable {
        basePage.navigateTo("Hypotheken");
    }

    @Dan("^kan de gebruiker een uitgebreide berekening maken$")
    public void kan_de_gebruiker_een_uitgebreide_berekening_maken() throws Throwable {
    	frontPage.assertUrlHypotheken();
        frontPage.assertThatUitgebreideBerekeningKnopIsVisible();
    }



}
