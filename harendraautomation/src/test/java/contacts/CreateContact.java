package contacts;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genric_utility.FileUtility;
import genric_utility.WebDriverUtility;
import object_repository.ContactPage;
import object_repository.LoginPage;
import object_repository.VeyContactPage;

public class CreateContact {

	public static void main(String[] args)
			throws InterruptedException, EncryptedDocumentException, IOException, ParseException,
			org.json.simple.parser.ParseException {

		// Read login data from JSON file
		String url = FileUtility.GetDataFJsonFile("url");
		String username = FileUtility.GetDataFJsonFile("username");
		String password = FileUtility.GetDataFJsonFile("password");

		// Read contact data from Excel file
		String lastName = FileUtility.GetDataFromExcelFile("Contact", 4, 0);
		String assistantName = FileUtility.GetDataFromExcelFile("Contact", 4, 2);
		String email = FileUtility.GetDataFromExcelFile("Contact", 4, 4);

		// Launch browser
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Open application
		driver.get(url);

		// Create Page Objects
		LoginPage loginPage = new LoginPage(driver);
		ContactPage contactPage = new ContactPage(driver);
		VeyContactPage verifyContactPage = new VeyContactPage(driver);
	

		// Login
		loginPage.getUsername().sendKeys(username);
		loginPage.getpassword().sendKeys(password);
		loginPage.getloginbutton().click();

		// Navigate to Contacts module
		contactPage.getLink().click();

		// Click Create Contact
		contactPage.getAddicon().click();

		// Enter Last Name
		contactPage.getLastname().sendKeys(lastName);

		// Select Account using popup
		String parentWindow = driver.getWindowHandle();

		driver.findElement(
				By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']"))
				.click();

		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		// Select Account
		driver.findElement(By.id("3")).click();

		Thread.sleep(2000);

		// Switch back to parent window
		driver.switchTo().window(parentWindow);

		// Select Lead Source
		String leadSource = "Employee";

		WebDriverUtility webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.select(contactPage.getLead(), leadSource);

		// Enter Phone
		contactPage.getPhone().sendKeys("1234567892");

		// Enter Email
		contactPage.getEmail().sendKeys(email);

		// Enter Assistant
		contactPage.getAssitance().sendKeys(assistantName);

		// Enter Description
		String descriptionText = "its is done";
		contactPage.getDescription().sendKeys(descriptionText);

		// Save Contact
		contactPage.getButton().click();

		// ================= VALIDATION =================

		String actualLastName = verifyContactPage.getlastname().getText();
		String actualEmail = verifyContactPage.getEmail().getText();
		String actualLeadSource = verifyContactPage.getLead().getText();
		String actualAssistant = verifyContactPage.getAssis().getText();
		String actualDescription = verifyContactPage.getDiscript().getText();

		// Last Name Validation
		System.out.println("========== LAST NAME VERIFICATION ==========");
		System.out.println("Expected Result : " + lastName);
		System.out.println("Actual Result   : " + actualLastName);

		if (lastName.equals(actualLastName)) {
			System.out.println("PASS : Last Name is matched");
		} else {
			System.out.println("FAIL : Last Name is not matched");
		}

		// Email Validation
		System.out.println("\n========== EMAIL VERIFICATION ==========");
		System.out.println("Expected Result : " + email);
		System.out.println("Actual Result   : " + actualEmail);

		if (email.equals(actualEmail)) {
			System.out.println("PASS : Email is matched");
		} else {
			System.out.println("FAIL : Email is not matched");
		}

		// Lead Source Validation
		System.out.println("\n========== LEAD SOURCE VERIFICATION ==========");
		System.out.println("Expected Result : " + leadSource);
		System.out.println("Actual Result   : " + actualLeadSource);

		if (leadSource.equals(actualLeadSource)) {
			System.out.println("PASS : Lead Source is matched");
		} else {
			System.out.println("FAIL : Lead Source is not matched");
		}

		// Assistant Validation
		System.out.println("\n========== ASSISTANT VERIFICATION ==========");
		System.out.println("Expected Result : " + assistantName);
		System.out.println("Actual Result   : " + actualAssistant);

		if (assistantName.equals(actualAssistant)) {
			System.out.println("PASS : Assistant is matched");
		} else {
			System.out.println("FAIL : Assistant is not matched");
		}

		// Description Validation
		System.out.println("\n========== DESCRIPTION VERIFICATION ==========");
		System.out.println("Expected Result : " + descriptionText);
		System.out.println("Actual Result   : " + actualDescription);

		if (descriptionText.equals(actualDescription)) {
			System.out.println("PASS : Description is matched");
		} else {
			System.out.println("FAIL : Description is not matched");
		}

		// Logout
		WebElement profile = contactPage.getprofile();

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(1000);

		// Close browser
		driver.quit();
	}
}