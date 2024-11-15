package BasePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {
	protected static  WebDriver driver;
	protected WebDriverWait wait;

	// creating constructor
	public AbstractBasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
	}

//methods
	public abstract String getPageTitle();

	public abstract String getPageHeader(By locator);

	public abstract String getWebElementText(By locator);

	public abstract WebElement getElement(By locator);

	public abstract void waitForElementPresent(By locator);

	public abstract void waitForPageTitle(String title);

	public abstract void waitForvisibilityOfElementLocated(By locator);
	// java generic

	public <Tpage extends BasePage> Tpage getInstance(Class<Tpage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
/*
 * Explanation of each part: <Tpage extends BasePage>:
 * 
 * This defines a generic method that works with any class that extends
 * BasePage. Tpage is a placeholder for the actual type of the page object that
 * the method will return. The generic type Tpage ensures that only classes that
 * are subtypes of BasePage can be passed to this method. This ensures type
 * safety. Class<Tpage> pageClass:
 * 
 * The method takes a parameter of type Class<Tpage>, which represents a class
 * object (such as LoginPage.class or HomePage.class). pageClass is a reference
 * to the class of the page object you want to instantiate.
 * pageClass.getDeclaredConstructor(WebDriver.class):
 * 
 * This fetches the constructor of the page class (Tpage) that takes a WebDriver
 * object as its argument. The getDeclaredConstructor method looks for a
 * constructor that matches the specified parameter types (in this case, a
 * WebDriver). newInstance(this.driver):
 * 
 * This creates a new instance of the page class (Tpage) by invoking the
 * constructor that takes the WebDriver parameter. The this.driver is passed to
 * that constructor, which means the newly created page object will use the
 * WebDriver from the current class (AbstractBasePage or BasePage). Overall
 * Purpose: This method is a factory method that:
 * 
 * Dynamically creates and returns an instance of a specific page object (which
 * extends BasePage). It takes the class type of the page object (Class<Tpage>
 * pageClass) and uses reflection to instantiate it, ensuring that the page
 * object gets the necessary WebDriver instance.
 */
