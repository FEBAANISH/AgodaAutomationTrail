package TestPackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import BasePackage.BasePage;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver; // for normal scenarios
	protected static final Logger log = LogManager.getLogger(BaseTest.class);

	// protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();//
	// for parallel execution
	public BasePage bp;

	/*
	 * public static WebDriver getDriverInstance() { return driver.get(); }
	 */
	@Parameters(value = { "browser" })

	@BeforeClass

	// public void setUpTest() {
	public void setUpTest(String browser) throws InterruptedException, MalformedURLException {
		// System.setProperty("webdriver.chrome.driver", "C:\\File\\chromedriver.exe");
		// GRID
		// DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setBrowserName(browser);
		// cap.setCapability("platform", "WINDOWS");
		// ChromeOptions option = new ChromeOptions();
		// option.merge(cap);
		// String hubUrl = "http://192.168.1.43:4444/wd/hub";
		// String browser = System.getProperty("browser");
		log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warning message");
        log.error("This is an error message");
        System.out.println(System.getProperty("user.dir"));
		if (browser.equalsIgnoreCase("chrome")) {

			// driver.set(ThreadGuard.protect(new ChromeDriver()));// for parallel execution
			driver = new ChromeDriver();
			log.error("Browser setup initialized successfully.");
			// driver = new RemoteWebDriver(URI.create(hubUrl.trim()).toURL(), option);
		} else if (browser.equalsIgnoreCase("ff")) {

			// driver.set(ThreadGuard.protect(new FirefoxDriver()));
			driver = new FirefoxDriver();
		} else {
			System.out.println("no browser");
		}
		log.info("navigated to browser");
		driver.get("https://www.agoda.com/en-in/");
		// getDriverInstance().get("https://www.agoda.com/en-in/");// for parallel
		// execution
		driver.manage().window().maximize();
		// bp = new BasePage(getDriverInstance());// bp = newBase Page()
		bp = new BasePage(driver);
		if (bp == null) {
			System.out.println("null");
		}
	}

	@AfterClass
	public void tearDown() {
		// driver.remove();
		// driver.quit();
	}

}
