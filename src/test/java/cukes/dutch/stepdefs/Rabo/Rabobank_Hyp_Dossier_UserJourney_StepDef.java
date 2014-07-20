package cukes.dutch.stepdefs.Rabo;

import cucumber.api.DataTable;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cukes.dutch.driver.SharedDriver;
import cukes.dutch.pageobjects.BasePage;
import cukes.dutch.pageobjects.rabobank.Rabobank_FrontPage_HypDossier;
import cukes.dutch.pageobjects.rabobank.Rabobank_HypDossier;
import cukes.dutch.pageobjects.rabobank.Rabobank_MainPage;

public class Rabobank_Hyp_Dossier_UserJourney_StepDef {

    private BasePage basePage;
    private Rabobank_MainPage rabo_main_page;
    private Rabobank_FrontPage_HypDossier frontPage_hypDossier;
    private Rabobank_HypDossier hypDossier_page;

    public Rabobank_Hyp_Dossier_UserJourney_StepDef(SharedDriver webDriver) {
        basePage = new BasePage(webDriver);
        frontPage_hypDossier = new Rabobank_FrontPage_HypDossier(webDriver);
        rabo_main_page = new Rabobank_MainPage(webDriver);
        hypDossier_page = new Rabobank_HypDossier(webDriver);
    }


    @Als("^een uitgebreide berekening maakt met de volgende waarde als starter:$")
    public void een_uitgebreide_berekening_maakt_met_de_volgende_waarde_als_starter(DataTable starter_input) throws Throwable {
        // in een echt
        rabo_main_page.open_uitgebreide_berekening();
        frontPage_hypDossier.kies_kbg_starter();
        hypDossier_page.maak_persoonlijke_berekening();
        // vul in inkomen en get van dataTable maand_inkomen
        // vul in nieuw huis van get dataTable value nieuw_huis
        // door de filter moet NHG nu al niet mogelijk zijn.
        // vul in eigen_geld van een 200000 via dataTable value eigen_geld
        // check NHG nog steeds niet mogelijk
    }

    @Dan("^kan de gebruiker geen gebruik maken van NHG$")
    public void kan_de_gebruiker_geen_gebruik_maken_van_NHG() throws Throwable {
        // Should fail, due to no calculation made in application
//        hyptoheek_dossier_page.what_is_status_nhg();
    }



}
