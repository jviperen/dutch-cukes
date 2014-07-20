package cukes.dutch.driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SharedDriver extends EventFiringWebDriver {
    private static WebDriver WEBDRIVER;
    private static final long TIMEOUT = 15;
    private static boolean SCREENSHOT;
    public boolean isScreenshot() {
        return SCREENSHOT;
    }
    private static PropertyLoader PROP_LOADER = new PropertyLoader();
    public static void setScreenshot(boolean screenshotValue) {
        SCREENSHOT = screenshotValue;
    }
    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            WEBDRIVER.quit();
        }
    };

    public static void logMessage(Level levelLogging, String message) {
        Logger.getLogger(SharedDriver.class.getName()).log(levelLogging,
                message);
    }

    static {
        WEBDRIVER = getDriverFromProperties();
        WEBDRIVER.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(WEBDRIVER);
    }

    private static WebDriver getDriverFromProperties() {
        WebDriver driver = null;
        String browser = PROP_LOADER.getPomProperty("browser.type");

        if (browser.equals("firefox")) {
            driver = getFireFoxDriver();
        }  else if (browser.equals("chrome")) {
            driver = getChromeDriver();
        } else if (browser.equals("phantom")) {
            driver = getPhantomDriver();
        }else if (browser.equals("")) {
            Assert.fail("No browser selected");

        }
        logMessage(Level.INFO, "Going to use browser type : " + browser);
        return driver;
    }


    @Override
    public void close() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException(
                    "You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }

    @Before
    public void setUp() {
        manage().deleteAllCookies();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (isScreenshot()) {
            scenario.write("Current Page URL is " + getCurrentUrl());
            try {
                byte[] screenshot = getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err
                        .println(somePlatformsDontSupportScreenshots.getMessage());
            }
        } else {
            logMessage(Level.INFO, "UnitDriver doens't make screenshots");
        }
    }

    // Drivers section

    public static WebDriver getFireFoxDriver() {
        WebDriver firefoxDriver;
        File pathToBinary = null;
        setScreenshot(true);
        //
        try {
            pathToBinary = new File(PROP_LOADER.loadLocalProperty("firefox.binary.location"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxDriver = new FirefoxDriver(ffBinary, firefoxProfile);

        return firefoxDriver;
    }

    public static WebDriver getChromeDriver() {
        WebDriver chromeDriver;
        String pathToBinary = null;
        try {
            pathToBinary = PROP_LOADER.loadLocalProperty("chrome.binary.location");
        } catch (IOException e) {
            e.printStackTrace();
        }
        setScreenshot(true);
        //
        System.setProperty("webdriver.chrome.driver",pathToBinary);
        chromeDriver = new ChromeDriver();
        return chromeDriver;
    }

    public static WebDriver getPhantomDriver(){
        WebDriver phantomJsDriver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps = DesiredCapabilities.phantomjs();
        caps.setCapability("takesScreenshot", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "D:\\data\\sla20246\\Downloads\\phantomjs-1.9.7-windows\\phantomjs.exe");
        phantomJsDriver = new PhantomJSDriver(caps);
        phantomJsDriver.manage().window().setSize( new Dimension( 1124, 850 ) );
        logMessage(Level.INFO, "We have a GHOSTDRIVER SELECTED!!");
        return phantomJsDriver;
    }

}
