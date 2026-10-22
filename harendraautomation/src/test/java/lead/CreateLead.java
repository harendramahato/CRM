package lead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import object_repository.CreateLeadPage;
import object_repository.LeadPage;
import object_repository.LeadPageVerify;
import object_repository.LoginPage;

/**
 * Test Script Name : CreateLead
 *
 * Description:
 * This script automates the creation of a new Lead in the Vtiger CRM
 * application and validates the Lead details after saving.
 *
 * Test Scenario:
 * 1. Launch Chrome browser.
 * 2. Maximize the browser window.
 * 3. Configure implicit wait.
 * 4. Open Vtiger CRM application.
 * 5. Login using valid credentials.
 * 6. Navigate to the Leads module.
 * 7. Open the Create Lead page.
 * 8. Enter Last Name.
 * 9. Enter Company Name.
 * 10. Select Lead Source.
 * 11. Select Industry.
 * 12. Enter Mobile Number.
 * 13. Save the Lead.
 * 14. Fetch the actual Lead details.
 * 15. Validate actual values against expected values.
 * 16. Logout from the application.
 * 17. Close the browser.
 *
 * Expected Result:
 * The Lead should be created successfully and all entered details
 * should match the details displayed after saving.
 *
 * Application : Vtiger CRM
 * Module      : Leads
 * Test Type   : Functional Automation Testing
 * Tool        : Selenium WebDriver
 * Author      : Harendra Mahato
 */

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {

	// Step 1: Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		LoginPage lp = new LoginPage(driver);
		LeadPage leads= new LeadPage(driver);
		CreateLeadPage clp = new CreateLeadPage(driver);
		LeadPageVerify lpv = new LeadPageVerify(driver);

	// Step 2: Maximize Browser Window
		driver.manage().window().maximize();

    // Step 3: Configure Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    // Step 4: Open Vtiger CRM Application
		driver.get("http://localhost:8888/");

	//  Step 5: Login to Vtiger CRM
	//	WebElement username = driver.findElement(By.name("user_name"));
	//	WebElement password = driver.findElement(By.name("user_password"));
    //  WebElement loginBtn = driver.findElement(By.id("submitButton"));
		
		
		
		WebElement usernameField = lp.getUsername();
		WebElement passwordField = lp.getpassword(); 
		WebElement loginButton = lp.getloginbutton();
		usernameField.sendKeys("admin");
		passwordField.sendKeys("manager");
		loginButton.click();

		// Step 6: Navigate to Leads Module
		//driver.findElement(By.linkText("Leads")).click();
		leads.getLeadsLink().click();

		// Step 7: Open Create Lead Page
	   //driver.findElement(By.cssSelector("img[alt='Create Lead...']")).click();
		leads.getCreateLead().click();

		// Step 8: Enter Last Name
		String lastName = "Kumar";
		String companyName = "Airtel";
		String leadSource = "Cold Call";
		String industry = "Apparel";
		String mobile = "9998765432";
		
		
      // WebElement lastNameField = driver.findElement(By.name("lastname"));
		WebElement lastnameField = clp.getLastNameField();
		lastnameField.sendKeys(lastName);

		// Step 9: Enter Company Name
      //  WebElement companyNameField = driver.findElement(By.name("company"));
        WebElement companyNameField = clp.getCompanyNameField();
		companyNameField.sendKeys(companyName);

		// Step 10: Select Lead Source
       // WebElement lead = driver.findElement(By.name("leadsource"));
		WebElement lead = clp.getLeadSourceDropdown();
		Select sel = new Select(lead);
		sel.selectByValue(leadSource);

		// Step 11: Select Industry

		//WebElement industryDd = driver.findElement(By.name("industry"));
		WebElement industryDd = clp.getIndustryDropdown();
		Select sele = new Select(industryDd);
		sele.selectByValue(industry);

		// Step 12: Enter Mobile Number
		//String mobile = "9998765432";

		//WebElement mobileField = driver.findElement(By.id("mobile"));
		WebElement mobileField = clp.getMobileField();
		mobileField.sendKeys(mobile);

		// Step 13: Save Lead
		//driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		clp.getSaveButton().click();

		// Step 14: Fetch Actual Lead Details
	   //	String actLastName =driver.findElement(By.id("dtlview_Last Name")).getText();
		  String actLastName= lpv.getActualLastName().getText();

		// String actCompanyName = driver.findElement(By.id("dtlview_Company")).getText();
		  String actCompanyName = lpv.getActualCompanyName().getText();
		
		//String actLeadSource =driver.findElement(By.id("dtlview_Lead Source")).getText();
		String actLeadSource= lpv.getActualLeadSource().getText();
		
	    //String actMobile =driver.findElement(By.id("dtlview_Mobile")).getText();
		String actMobile = lpv.getActualMobile().getText();
	   
		//String actIndustry =driver.findElement(By.id("dtlview_Industry")).getText();
		String actIndustry = lpv.getActualIndustry().getText();
		
		
		// Step 15: Validate Lead Details
		if (actLastName.equals(lastName)
				&& actCompanyName.equals(companyName)
				&& actLeadSource.equals(leadSource)
				&& actMobile.equals(mobile)
				&& actIndustry.equals(industry)) {

			System.out.println("Lead Successfully Created");
			System.out.println("All Lead details matched successfully");

		} else {

			System.out.println("Lead Creation Failed");
			System.out.println("Lead details did not match");
		}

		// Step 16: Logout from Application
	//	WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		WebElement profile = leads.getprofile();

		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();

		driver.findElement(By.linkText("Sign Out")).click();

		// Step 17: Wait Before Closing Browser
		Thread.sleep(1000);

		// Step 18: Close Browser
		driver.quit();
	}
}
