package Listerners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import UtilPackage.Screenshot_Util;

import TestPackage.BaseTest;

public class ListernersClass implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
		 WebDriver driver = ((BaseTest) result.getInstance()).driver;
		 Screenshot_Util Screenshot = new Screenshot_Util(driver);
		 Screenshot.takePageScreenshot();
	}

}
