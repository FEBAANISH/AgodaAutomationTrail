package Pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasePackage.BasePage;

public class CreateAccountPage extends BasePage {

	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(CreateAccountPage.class);

	public CreateAccountPage(WebDriver driver) {
		super(driver);

	}

	private By create_acc_button = By.xpath("//button[@data-element-name=\"sign-up-button\"]");
	private By SignUpFrame = By.xpath("//iframe[@title='Universal login']");
	private By FrameTitleValidation = By.xpath("//div[@data-cy='form-heading']/h2");
	private By emailTextField = By.xpath("//input[@data-cy='unified-email-input']");
	private By continueButton = By.xpath("//button[@data-cy=\"unified-email-continue-button\"]");
	private By passwordButton = By.xpath("//button[contains(@data-cy,\"password-button\")]");
	// private By SignupTitle =
	// By.xpath("/html/body/div[@id='root']/div/div/div/h3");

	public WebElement getContinueButton() {
		return driver.findElement(continueButton);
	}

	public WebElement getPasswordButton() {
		return driver.findElement(passwordButton);
	}

	public WebElement getCreate_acc_button() {
		return driver.findElement(create_acc_button);
	}

	public WebElement getSignUpFrame() {
		return driver.findElement(SignUpFrame);
	}

	public WebElement getFrameTitleValidation() {
		return driver.findElement(FrameTitleValidation);
	}

	public WebElement getFrameTitle() {
		return driver.findElement(FrameTitleValidation);
	}

	public WebElement getEmailTextField() {
		return driver.findElement(emailTextField);
	}

	public void continuButtonClick() {
		logger.info("Clicking on the continue button.");
		getContinueButton().click();
	}

	public void passwordButtonClick() {
		logger.info("Clicking on the password button.");
		getPasswordButton().click();
	}

	public void create_Account_Button_Click() {
		logger.info("Clicking on the create account button.");
		getCreate_acc_button().click();
	}

	public boolean waitForPasswordButton() {
		waitForElementPresent(passwordButton);
		return true;
	}

	public void waitForCreateButton() {
		waitForElementPresent(create_acc_button);
		logger.info("Create account button is present.");

	}

	public void waitForFrame() {
		waitForvisibilityOfElementLocated(SignUpFrame);

	}

	public void waitForTitle() {
		waitForvisibilityOfElementLocated(FrameTitleValidation);

	}

	public boolean waitForEmailTextField() {
		waitForvisibilityOfElementLocated(emailTextField);
		return true;
	}

	public void emailValue(String email) {
		logger.info("Entering email: " + email);
		getEmailTextField().sendKeys(email);
	}
	
	

	public boolean switchedToFrame() {
		try {

			logger.info("Switching to the sign-up iframe.");
			driver.switchTo().frame(driver.findElement(SignUpFrame));
			return true; // Successfully switched to the frame
		} catch (NoSuchElementException e) {
			logger.error("Failed to switch to the sign-up iframe: " + e.getMessage());
			return false; // Switching failed
		}
	}

	public String ValidatingFrameTitle() {

		if (switchedToFrame()) {
			waitForTitle();

			return getFrameTitle().getText();

		} else {
			System.out.println("Failed to switch to the signup iframe.");
			return null;
		}

	}

	public String validateFrameTitle() {

		String frameTitle = ValidatingFrameTitle();
		System.out.println("Frame Title: " + frameTitle);
		return frameTitle;

	}

	public String emailSection(String email) {
		try {
	        if (waitForEmailTextField()) {
	            logger.info("Email text field is visible. Entering email...");
	            emailValue(email);
	            logger.info("Email entered successfully. Clicking continue button...");
	            continuButtonClick();
	            
	            if (waitForPasswordButton()) {
	                logger.info("Password button is visible. Clicking password button...");
	                passwordButtonClick();
	            } else {
	                logger.error("Password button is not visible.");
	            }
	        } else {
	            logger.error("Email text field is not visible.");
	        }
	    } catch (Exception e) {
	        logger.error("An error occurred while entering email and proceeding: " + e.getMessage());
	    }
		return email;
	}

}
