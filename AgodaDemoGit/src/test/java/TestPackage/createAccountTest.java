package TestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import ExtendedReport.extendTestReport;
import Listerners.RetryAnalyzer;
import Pages.CreateAccountPage;

public class createAccountTest extends BaseTest {

	private CreateAccountPage createAccountPage;
	private extendTestReport report;

	@BeforeMethod
	public void NavigateToCreateAccountPage() {

		report = new extendTestReport(driver);
		report.initializeReport();

	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void SwitchToFrame() {

		createAccountPage = bp.getInstance(CreateAccountPage.class);
		createAccountPage.waitForCreateButton();
		createAccountPage.create_Account_Button_Click();
		createAccountPage.waitForFrame();
		String assertFrameTitle = createAccountPage.validateFrameTitle();
		try {
			log.info("verifying Title");
			Assert.assertEquals(assertFrameTitle, "Sign in or create an account", "Frame title does not match!");
			report.logTestWithScreenshot("Switch to frame", true);

		} catch (AssertionError e) {
			report.logTestWithScreenshot("Frame Not found", false);
			throw e;

		}

	}

	@Test
	public void emailSectionFunctionality()

	{
		createAccountPage = bp.getInstance(CreateAccountPage.class);

		// Act
		createAccountPage.emailSection("agoda02@gmail.com");

		// Assertions (Example: Check if email is entered correctly)
		String enteredEmail = createAccountPage.emailSection("agoda02@gmail.com");
		Assert.assertEquals(enteredEmail, "agoda02@gmail.com", "Email entered is not correct.");

		// Log success
		log.info("Email section functionality executed successfully with email: agoda02@gmail.com");

	}

	@AfterMethod
	public void reportFlush() {
		report.flushReport();
	}

}
