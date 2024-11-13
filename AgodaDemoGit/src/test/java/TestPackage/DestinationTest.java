package TestPackage;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ExtendedReport.extendTestReport;
import Pages.DestinationPage;

public class DestinationTest extends BaseTest{
	private DestinationPage dp;
	private extendTestReport report;
	
	@BeforeMethod
	public void NavigateToCreateAccountPage() {

		report = new extendTestReport(driver);
		report.initializeReport();

	}
	
	@Test
	public void EnterValueInDestinationTextBox() throws FileNotFoundException, IOException, ParseException
	{
		
		dp = bp.getInstance(DestinationPage.class);
		dp.clearDestinationTextBox();
		dp.EnterValueInDestionTextBox();
	}

}
