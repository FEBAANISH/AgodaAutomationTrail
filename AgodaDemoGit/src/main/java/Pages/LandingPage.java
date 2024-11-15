package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasePackage.BasePage;

public class LandingPage extends BasePage {

	public LandingPage(WebDriver driver) {
		super(driver);

	}

	// encapsulation

	private By createAcc_button = By.xpath("//button[@data-element-name=\"sign-up-button\"]");

//getter method 
	public WebElement getCreateAcc_button() {
		return driver.findElement(createAcc_button);
	}

	public String getLandingPageTitle() {
		return getPageTitle();
	}

}
