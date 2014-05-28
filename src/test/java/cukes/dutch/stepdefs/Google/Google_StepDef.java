package cukes.dutch.stepdefs.Google;

import cucumber.api.PendingException;
import cucumber.api.java.nl.*;
import cukes.dutch.driver.SharedDriver;
import cukes.dutch.pageobjects.google.Google_PageObject;
import org.openqa.selenium.WebDriver;

public class Google_StepDef {
    private Google_PageObject google_pageObject;
    @SuppressWarnings("unused")
	private WebDriver webDriver;

    public Google_StepDef(SharedDriver webDriver) {
        this.webDriver = webDriver;
        google_pageObject = new Google_PageObject(webDriver);
    }

    @Gegeven("^we moeten iets in de achtergrond doen als setup, gebruik dit alleen als setUp$")
    public void we_moeten_iets_in_de_achtergrond_doen_als_setup_gebruik_dit_alleen_als_setUp() throws Throwable {
        google_pageObject.getWebDriver().getTitle();
        google_pageObject.log_setup_showcase();
    }

    @Als("^er wordt gezocht met \"([^\"]*)\"$")
    public void er_wordt_gezocht_met(String zoekCriteria) throws Throwable {
        google_pageObject.zoek_met_criteria(zoekCriteria);
    }

    @Dan("^wordt \"([^\"]*)\" gevonden op eerste positie$")
    public void wordt_gevonden_op_eerste_positie(String zoekResultaatEerstePositie) throws Throwable {
        google_pageObject.assert_eerste_zoek_resultaat(zoekResultaatEerstePositie);
    }
}
