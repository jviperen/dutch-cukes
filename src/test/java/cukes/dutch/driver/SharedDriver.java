package cukes.dutch.driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cukes.dutch.driver.utils.PropertyLoader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SharedDriver extends EventFiringWebDriver {
    private static WebDriver WEBDRIVER;
    private static final long TIMEOUT = 15;
    private static boolean SCREENSHOT;
    private static PropertyLoader PROP_LOADER = new PropertyLoader();
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String PHANTOM = "phantom";

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            WEBDRIVER.quit();
        }
    };
    private boolean isScreenshot() {
        return SCREENSHOT;
    }
    public static void setScreenshot(boolean screenshotValue) {
        SCREENSHOT = screenshotValue;
    }

    public static void logMessage(Level levelLogging, String message) {
        Logger.getLogger(SharedDriver.class.getName()).log(levelLogging,
                message);
    }

    static {
        WEBDRIVER = getDriverFromProperties();
        WEBDRIVER.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        WEBDRIVER.manage().timeouts().pageLoadTimeout(TIMEOUT, TimeUnit.SECONDS);
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedDriver() {
        super(WEBDRIVER);
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

    // Retrieve driver name from pom file

    private static WebDriver getDriverFromProperties() {
        String browser = PROP_LOADER.getPomProperty("browser.type");
        printBrowser(browser);
        if (browser.equals(FIREFOX)) {
            WEBDRIVER = getFireFoxDriver();
        } else if (browser.equals(CHROME)) {
            WEBDRIVER = getChromeDriver();
        } else if (browser.equals(PHANTOM)) {
            WEBDRIVER = getPhantomDriver();
        }
        return WEBDRIVER;
    }

    private static void printBrowser(String browser){
        System.out.println("***************************************************************");
        System.out.println(" We are going to use driver : " + browser);
        System.out.println("***************************************************************");
    }



    // Drivers section

    public static WebDriver getFireFoxDriver(){
        WebDriver firefoxDriver;
        // FF binary and profile
        File pathToBinary = new File(PROP_LOADER.getLocalDriverBinary("firefox"));
        setScreenshot(true);
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxDriver = new FirefoxDriver(ffBinary, firefoxProfile);
        //
        return firefoxDriver;
    }

    public static WebDriver getChromeDriver(){
        final String chromeDriverSystemProperty = "webdriver.chrome.driver";
        WebDriver chromeDriver;
        // Chrome settings
        String pathToBinary = PROP_LOADER.getLocalDriverBinary(CHROME);
        setScreenshot(true);
        System.setProperty(chromeDriverSystemProperty, pathToBinary);
        chromeDriver = new ChromeDriver();
        //
        return chromeDriver;
    }

    public static WebDriver getPhantomDriver(){
        WebDriver phantomJsDriver;
        // Phantom  settings
//        DesiredCapabilities caps
        DesiredCapabilities caps = DesiredCapabilities.phantomjs();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                PROP_LOADER.getLocalDriverBinary(PHANTOM));
        caps.setCapability("takesScreenshot", true);
        phantomJsDriver = new PhantomJSDriver(caps);
        //
        return phantomJsDriver;
    }

}
