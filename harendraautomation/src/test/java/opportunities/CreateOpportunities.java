package opportunities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import object_repository.LoginPage;
import object_repository.OpportunityPage;
import object_repository.OpportunityPageValid;

/**
 * Test Script Name : CreateOpportunities
 *
 * Description:
 * This script automates the creation of a new Opportunity in the
 * Vtiger CRM application and validates the Opportunity details
 * after saving.
 *
 * Test Scenario:
 * 1. Launch Chrome browser.
 * 2. Maximize the browser window.
 * 3. Configure implicit wait.
 * 4. Open Vtiger CRM application.
 * 5. Login using valid credentials.
 * 6. Navigate to Opportunities module.
 * 7. Open Create Opportunity page.
 * 8. Enter Opportunity Name.
 * 9. Select Related Organization.
 * 10. Enter Amount.
 * 11. Select Opportunity Type.
 * 12. Enter Closing Date.
 * 13. Select Lead Source.
 * 14. Enter Next Step.
 * 15. Select Assigned User.
 * 16. Select Sales Stage.
 * 17. Select Campaign.
 * 18. Enter Probability.
 * 19. Save the Opportunity.
 * 20. Fetch actual Opportunity details.
 * 21. Validate actual values against expected values.
 * 22. Logout from the application.
 * 23. Close the browser.
 *
 * Expected Result:
 * The Opportunity should be created successfully and all entered
 * details should match the details displayed after saving.
 *
 * Application : Vtiger CRM
 * Module      : Opportunities
 * Test Type   : Functional Automation Testing
 * Tool        : Selenium WebDriver
 * Author      : Harendra Mahato
 */

public class CreateOpportunities {

	public static void main(String[] args) throws InterruptedException {

		// Step 1: Launch Chrome Browser
		WebDriver driver = new ChromeDriver();

		LoginPage lp = new LoginPage(driver);
		OpportunityPage op = new OpportunityPage(driver);
		OpportunityPageValid opv = new OpportunityPageValid(driver);

		// Step 2: Maximize Browser Window
		driver.manage().window().maximize();

		// Step 3: Configure Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Step 4: Open Vtiger CRM Application
		driver.get("http://localhost:8888/");

		// Step 5: Login to Vtiger CRM
		WebElement usernameField = lp.getUsername();
		WebElement passwordField = lp.getpassword();
		WebElement loginButton = lp.getloginbutton();

		usernameField.sendKeys("admin");
		passwordField.sendKeys("manager");
		loginButton.click();

		// Step 6: Navigate to Opportunities Module
		op.getOpportunitiesLink().click();

		// Step 7: Open Create Opportunity Page
		op.getCreateOpportunityButton().click();

		// Step 8: Enter Opportunity Details

		String opportunityName = "Zudio" + System.currentTimeMillis();
		String amount = "5000";
		String opportunityType = "New Business";
		String closingDate = "2026/09/18";
		String leadSource = "Partner";
		String nextStep = "move on";
		String assignedUser = "1";
		String salesStage = "Perception Analysis";
		String probability = "88";

		// Enter Opportunity Name
		op.getOpportunityNameField().sendKeys(opportunityName);

		// Step 9: Select Related Organization

		String parentWindow = driver.getWindowHandle();
        op.getOrganizationSelectButton().click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		// Select Organization
		op.getOrganizationSelectButton().click();

		// Switch back to main window
		driver.switchTo().window(parentWindow);

		// Step 10: Enter Related To
		op.getRelatedToField().sendKeys("old");

		// Step 11: Enter Amount
		op.getAmountField().sendKeys(amount);

		// Step 12: Select Opportunity Type
		WebElement opportunityTypeDropdown = op.getOpportunityTypeDropdown();
		Select typeSelect = new Select(opportunityTypeDropdown);
		typeSelect.selectByValue(opportunityType);

		// Step 13: Enter Closing Date
		op.getClosingDateField().sendKeys(closingDate);

		// Step 14: Select Lead Source
		WebElement leadSourceDropdown = op.getLeadSourceDropdown();
		Select leadSourceSelect = new Select(leadSourceDropdown);
		leadSourceSelect.selectByValue(leadSource);

		// Step 15: Enter Next Step
		op.getNextStepField().sendKeys(nextStep);

		// Step 16: Select Assigned User
		WebElement assignedUserDropdown = op.getAssignedUserDropdown();
		Select assignedUserSelect = new Select(assignedUserDropdown);
		assignedUserSelect.selectByValue(assignedUser);

		// Step 17: Select Sales Stage
		WebElement salesStageDropdown = op.getSalesStageDropdown();
		Select salesStageSelect = new Select(salesStageDropdown);
		salesStageSelect.selectByValue(salesStage);

		// Step 18: Select Campaign

		String opportunityWindow = driver.getWindowHandle();

		op.getCampaignSelectButton().click();

		Set<String> campaignWindows = driver.getWindowHandles();

		for (String window : campaignWindows) {
			if (!window.equals(opportunityWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		// Select User Conference Campaign
		op.getUserConference().click();

		// Switch back to Opportunity window
		driver.switchTo().window(opportunityWindow);

		// Step 19: Enter Probability
		op.getProbabilityField().sendKeys(probability);

		// Step 20: Save Opportunity
		op.getSaveButton().click();

		// Step 21: Fetch Actual Opportunity Details

		String actOpportunityName = opv.getOpportunityNameValidation().getText();
        String actAmount = opv.getAmountValidation().getText();
        String actOpportunityType =opv.getOpportunityTypeValidation().getText();

		// Step 22: Validate Opportunity Details

		if (actOpportunityName.equals(opportunityName)
				&& actAmount.equals(amount)
				&& actOpportunityType.equals(opportunityType)) {

			System.out.println("Opportunity Successfully Created");
			System.out.println("All Opportunity details matched successfully");

		} else {

			System.out.println("Opportunity Creation Failed");
			System.out.println("Opportunity details did not match");

			System.out.println("Expected Opportunity Name : " + opportunityName);
			System.out.println("Actual Opportunity Name   : " + actOpportunityName);

			System.out.println("Expected Amount           : " + amount);
			System.out.println("Actual Amount             : " + actAmount);

			System.out.println("Expected Opportunity Type : " + opportunityType);
			System.out.println("Actual Opportunity Type   : " + actOpportunityType);
		}

		// Step 23: Logout from Application

		WebElement profile = opv.getUserProfile();

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		opv.getSignOut().click();

		// Step 24: Wait Before Closing Browser
		Thread.sleep(1000);

		// Step 25: Close Browser
		driver.quit();
	}
}

