package cukes.dutch.pageobjects.rabobank;

import cukes.dutch.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RhdFrontPageObject extends BasePage {

	public RhdFrontPageObject(WebDriver webDriver) {
		super(webDriver);
	}

    private By uitgebreideBerekeningKnop = By.className("ra_bh_redirect_m11");

    public void assertThatUitgebreideBerekeningKnopIsVisible(){
    	assertElementPresent(uitgebreideBerekeningKnop);
    }

    public void assertUrlHypotheken(){
    	final String currentUrlShouldBe = "https://www.rabobank.nl/particulieren/producten/hypotheken/";
    	assertCurrentUrl(currentUrlShouldBe);
    }


}
