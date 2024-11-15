package TestPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ExtendedReport.extendTestReport;
import Pages.UserRegistrationPage;

public class UserRegistrationTest extends BaseTest {

	private UserRegistrationPage userregister;
	private extendTestReport report;

	@BeforeMethod

	public void reportFunctionality(WebDriver driver) {
		report = new extendTestReport(driver);
		report.initializeReport();
	}

	@Test
	public void findEmailField() {
		userregister = bp.getInstance(UserRegistrationPage.class);
		log.error("email text found");
		
		userregister.clearEamidIdField();
		log.error("email text is cleaned");
		report.logTestWithScreenshot("Email field is found", true);

	}

	@AfterMethod
	public void reportFlush() {
		report.flushReport();
	}
}
