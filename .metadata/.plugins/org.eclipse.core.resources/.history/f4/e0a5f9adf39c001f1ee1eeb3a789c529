package UtilPackage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screenshot_Util {

	private WebDriver driver;
	private static final String basePath = System.getProperty("user.dir") + "\\Screenshot\\";

	public Screenshot_Util(WebDriver driver) {
		this.driver = driver;
	}

	// take screenshot of web element
	public void takeElementScreenshot(WebElement element, String Filename) {
		File screenshotDir = new File(basePath);
		File scr = element.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String timestamp = LocalDateTime.now().format(formatter);
		try {

			FileUtils.cleanDirectory(screenshotDir);
			File destFile = new File(basePath + Filename + "_" + timestamp + ".png");
			FileUtils.forceMkdir(new File(basePath));
			FileUtils.copyFile(scr, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// take screenshot of entire page
	public void takePageScreenshot() {
		//File screenshotDir = new File(basePath);
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File Pagescr = scrShot.getScreenshotAs(OutputType.FILE);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String timestamp = LocalDateTime.now().format(formatter);
		/*try {
			//FileUtils.cleanDirectory(screenshotDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		File pagedestFile = new File(basePath + "_" + timestamp + ".png");
		try {
			FileUtils.forceMkdir(new File(basePath));
		} catch (IOException e) {

			e.printStackTrace();
		}
		try {

			FileUtils.copyFile(Pagescr, pagedestFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
