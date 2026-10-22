package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	  // Constructor
	   public OpportunityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Opportunities module
    @FindBy(linkText = "Opportunities")
    private WebElement opportunitiesLink;

    // Create Opportunity
    @FindBy(css = "img[alt='Create Opportunity...']")
    private WebElement createOpportunityButton;

    // Opportunity Name
    @FindBy(name = "potentialname")
    private WebElement opportunityNameField;

    // Organization Select
    @FindBy(css = "img[src='themes/softed/images/select.gif']")
    private WebElement organizationSelectButton;

    // Related To
    @FindBy(id = "related_to_display")
    private WebElement relatedToField;

    // Amount
    @FindBy(name = "amount")
    private WebElement amountField;

    // Opportunity Type
    @FindBy(name = "opportunity_type")
    private WebElement opportunityTypeDropdown;

    // Closing Date
    @FindBy(name = "closingdate")
    private WebElement closingDateField;

    // Lead Source
    @FindBy(name = "leadsource")
    private WebElement leadSourceDropdown;

    // Next Step
    @FindBy(id = "nextstep")
    private WebElement nextStepField;

    // Assigned User
    @FindBy(name = "assigned_user_id")
    private WebElement assignedUserDropdown;

    // Sales Stage
    @FindBy(name = "sales_stage")
    private WebElement salesStageDropdown;

    // Campaign Select
    @FindBy(xpath = "//input[@name='campaignname']/following-sibling::img[@alt='Select']")
    private WebElement campaignSelectButton;

    // linkText("User Conference"
    
    @FindBy(linkText ="User Conference")
    private WebElement userconference;
    
    // Probability
    @FindBy(id = "probability")
    private WebElement probabilityField;

    // Save Button
    @FindBy(name = "button")
    private WebElement saveButton;

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getCreateOpportunityButton() {
		return createOpportunityButton;
	}

	public WebElement getOpportunityNameField() {
		return opportunityNameField;
	}

	public WebElement getOrganizationSelectButton() {
		return organizationSelectButton;
	}

	public WebElement getRelatedToField() {
		return relatedToField;
	}

	public WebElement getAmountField() {
		return amountField;
	}

	public WebElement getOpportunityTypeDropdown() {
		return opportunityTypeDropdown;
	}

	public WebElement getClosingDateField() {
		return closingDateField;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getNextStepField() {
		return nextStepField;
	}

	public WebElement getAssignedUserDropdown() {
		return assignedUserDropdown;
	}

	public WebElement getSalesStageDropdown() {
		return salesStageDropdown;
	}

	public WebElement getCampaignSelectButton() {
		return campaignSelectButton;
	}

	public WebElement getProbabilityField() {
		return probabilityField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
   
	 
	 public WebElement getUserConference() {
	 return userconference;
}
}
