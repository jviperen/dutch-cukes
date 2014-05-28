package cukes.dutch.stepdefs;

import cucumber.api.java.nl.Gegeven;
import cukes.dutch.driver.SharedDriver;
import cukes.dutch.pageobjects.rabobank.RaboMainPageObject;
import org.openqa.selenium.WebDriver;

public class MainStepDef {
    private RaboMainPageObject raboMainPage;
    @SuppressWarnings("unused")
	private WebDriver webDriver;

    public MainStepDef(SharedDriver webDriver) {
        this.webDriver = webDriver;
        raboMainPage = new RaboMainPageObject(webDriver);
    }

    @Gegeven("^de url \"([^\"]*)\" is geopend$")
    public void de_url_is_geopend(String url) throws Throwable {
       raboMainPage.openUrl(url);
    }
}
