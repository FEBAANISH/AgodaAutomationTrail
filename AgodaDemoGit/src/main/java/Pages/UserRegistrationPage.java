package Pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.BasePage;

public class UserRegistrationPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	private Logger log;

	public UserRegistrationPage(WebDriver driver, Logger log) {
		super(driver);
		this.log = log;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@data-cy='unified-email-input']")
	private WebElement email_id;

	

	public void clearEamidIdField() {
		email_id.clear();
	}
}
