package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPageValid {
	
	  public OpportunityPageValid(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    // =================================================
	    // VALIDATION SECTION
	    // =================================================

	    // Opportunity Name
	    @FindBy(css = "[id='dtlview_Opportunity Name']")
	    private WebElement opportunityNameValidation;

	    // Related Organization
	    @FindBy(linkText = "vtiger")
	    private WebElement relatedOrganizationValidation;

	    // Amount
	    @FindBy(id = "dtlview_Amount")
	    private WebElement amountValidation;

	    // Opportunity Type
	    @FindBy(id = "dtlview_Type")
	    private WebElement opportunityTypeValidation;


	    // =================================================
	    // LOGOUT SECTION
	    // =================================================

	    // User Profile
	    @FindBy(css = "[src='themes/softed/images/user.PNG']")
	    private WebElement userProfile;

	    // Sign Out
	    @FindBy(linkText = "Sign Out")
	    private WebElement signOut;



	    // =================================================
	    // GETTERS
	    // =================================================

	    public WebElement getOpportunityNameValidation() {
	        return opportunityNameValidation;
	    }

	    public WebElement getRelatedOrganizationValidation() {
	        return relatedOrganizationValidation;
	    }

	    public WebElement getAmountValidation() {
	        return amountValidation;
	    }

	    public WebElement getOpportunityTypeValidation() {
	        return opportunityTypeValidation;
	    }

	    public WebElement getUserProfile() {
	        return userProfile;
	    }

	    public WebElement getSignOut() {
	        return signOut;
	    }
	}

