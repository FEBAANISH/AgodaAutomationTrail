package Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasePackage.BasePage;

public class DestinationPage extends BasePage {

	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(CreateAccountPage.class);

	public DestinationPage(WebDriver driver) {
		super(driver);

	}

	private By destination_textbox = By.xpath("//input[@role=\"combobox\"]");

	public WebElement getDestination_textbox() {
		return driver.findElement(destination_textbox);
	}

	public void clearDestinationTextBox() {
		waitForElementPresent(destination_textbox);
		logger.error("clearing destinationTextBox");
		getDestination_textbox().click();
	}

	public String DestinationJsonReader() throws FileNotFoundException, IOException, ParseException {
		JSONParser jp = new JSONParser();
		JSONObject obj = (JSONObject) jp.parse(new FileReader(
				"C:\\Users\\febaz\\OneDrive\\Documents\\GitProject\\AgodaAutomationTrail\\AgodaDemoGit\\src\\test\\java\\TestData\\destination.json"));
		JSONArray locationArray = (JSONArray) obj.get("Destination");
		if (locationArray != null && !locationArray.isEmpty()) {
			// Get the first element in the array (a JSONObject)
			JSONObject destination = (JSONObject) locationArray.get(0);

			// Retrieve the "location" key from the first object
			String location = (String) destination.get("location");
			return location;
		} else {
			// Handle the case where the array is empty or not found
			throw new ParseException(ParseException.ERROR_UNEXPECTED_EXCEPTION,
					"Destination array is empty or not found.");
			//working
		}
	}

	public void EnterValueInDestionTextBox() throws FileNotFoundException, IOException, ParseException {
		String jsonlocation = DestinationJsonReader();
		logger.error("entering value in  destinationTextBox");
		getDestination_textbox().sendKeys(jsonlocation);
	}
}
