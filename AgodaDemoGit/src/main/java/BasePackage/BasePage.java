package BasePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractBasePage {

	public BasePage(WebDriver driver) {
		super(driver);

	}

	@Override
	public String getPageTitle() {

		return driver.getTitle();
	}

	@Override
	public String getPageHeader(By locator) {

		return getElement(locator).getText();
	}

	@Override
	public String getWebElementText(By locator) {

		return getElement(locator).getText();
	}

	@Override
	public WebElement getElement(By locator) {

		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("some error occured");
			e.printStackTrace();
		}
		return element;

	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("some expection" + locator.toString());
		}
	}

	@Override
	public void waitForPageTitle(String title) {
		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("error occured while waiting for the element" + title);
		}
	}

	@Override
	public void waitForvisibilityOfElementLocated(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {

			System.out.println("Element not visible" + locator.toString());
		}
	}

}
