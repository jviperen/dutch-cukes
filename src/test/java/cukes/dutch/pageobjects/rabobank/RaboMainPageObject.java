package cukes.dutch.pageobjects.rabobank;

import cukes.dutch.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;

public class RaboMainPageObject extends BasePage {

	public RaboMainPageObject(WebDriver webDriver) {
		super(webDriver);
	}

	public void openUrl(String url) {
		getWebDriver().get(url);
	}

}
