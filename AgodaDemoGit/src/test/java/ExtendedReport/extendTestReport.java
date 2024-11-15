package ExtendedReport;

import java.io.File;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extendTestReport {

	public static ExtentSparkReporter sparkreport;
	public static ExtentTest test;
	public static ExtentReports extent;
	private WebDriver driver;

	public extendTestReport(WebDriver driver) {
		this.driver = driver;

	}

	public void initializeReport() {
		sparkreport = new ExtentSparkReporter(
				System.getProperty("user.dir") + "\\src\\main\\resources\\Report\\SparkReport.html");
		sparkreport.config().setDocumentTitle("Automation Report");
		sparkreport.config().setReportName("Agoda Automation Test Result");
		sparkreport.config().setTheme(Theme.STANDARD);
		sparkreport.config().setTimeStampFormat("EEEE, MMMM dd, yyyy hh:mm a zzz");
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
	}

	public void logTestWithScreenshot(String testName, boolean isTestPassed) {
		test = extent.createTest(testName);
		if (isTestPassed) {
			test.pass("Test Passed");
		} else {
			test.fail("Test Failed");
			// Take screenshot and attach it to the report
			String screenshotPath = takeScreenshot(testName); // Capture screenshot
			test.addScreenCaptureFromPath(screenshotPath); // Attach screenshot to the report
		}
	}

	private String takeScreenshot(String testName) {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File screenshotFile = scrShot.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String timestamp = LocalDateTime.now().format(formatter);
		String screenshotPath = System.getProperty("user.dir") + "\\Screenshot\\" + testName + "_" + timestamp + ".png";

		try {
			FileUtils.copyFile(screenshotFile, new File(screenshotPath)); // Save screenshot
		} catch (IOException e) {
			e.printStackTrace();
		}

		return screenshotPath; // Return the screenshot file path
	}

	public void flushReport() {
		extent.flush();
	}

}
