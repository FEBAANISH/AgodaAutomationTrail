package TestPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ExtendedReport.extendTestReport;
import Pages.LandingPage;

public class LandingPageTest extends BaseTest {

	private extendTestReport report;

	@BeforeMethod
	public void landingpage() {
		report = new extendTestReport(driver);
		report.initializeReport();
	}

	@Test
	public void VerifyLandingPageTitle() {

		String LandingpageTitle = bp.getInstance(LandingPage.class).getLandingPageTitle();
		System.out.println("the landing page title:" + LandingpageTitle);

		Assert.assertEquals(LandingpageTitle,
				"Agoda Official Site | Free Cancellation & Booking Deals | Over 2 Million Hotels");
		report.logTestWithScreenshot("Landing Page passed", true);

	}

	@Test

	public void StringSplitDemo() {
		String LandingPage = bp.getInstance(LandingPage.class).getLandingPageTitle();
		System.out.println(LandingPage);
		String[] LandingPageString = LandingPage.split("\\|");
		for (String FinalString : LandingPageString) {
			System.out.println(FinalString.trim());
		}

	}

	@AfterMethod
	public void reportFlush() {
		report.flushReport();
	}

}
