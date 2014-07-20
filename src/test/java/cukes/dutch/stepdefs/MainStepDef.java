package cukes.dutch.stepdefs;

import cucumber.api.java.nl.Gegeven;
import cukes.dutch.driver.SharedDriver;
import cukes.dutch.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;

public class MainStepDef {
    private BasePage basePage;
    @SuppressWarnings("unused")
	private WebDriver webDriver;

    public MainStepDef(SharedDriver webDriver) {
        this.webDriver = webDriver;
        basePage = new BasePage(webDriver);
    }

    @Gegeven("^de url \"([^\"]*)\" is geopend$")
    public void de_url_is_geopend(String url) throws Throwable {
       basePage.openUrl(url);
    }
}
