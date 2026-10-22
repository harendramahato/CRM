package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {

			public CreateLeadPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}

			// Last Name
			@FindBy(name = "lastname")
			private WebElement lastNameField;

			// Company Name
			@FindBy(name = "company")
			private WebElement companyNameField;

			// Lead Source dropdown
			@FindBy(name = "leadsource")
			private WebElement leadSourceDropdown;

			// Industry dropdown
			@FindBy(name = "industry")
			private WebElement industryDropdown;

			// Mobile number
			@FindBy(id = "mobile")
			private WebElement mobileField;

			// Save button
			@FindBy(css = "input[title='Save [Alt+S]']")
			private WebElement saveButton;


			public WebElement getLastNameField() {
				return lastNameField;
			}

			public void setLastNameField(WebElement lastNameField) {
				this.lastNameField = lastNameField;
			}

			public WebElement getCompanyNameField() {
				return companyNameField;
			}

			public void setCompanyNameField(WebElement companyNameField) {
				this.companyNameField = companyNameField;
			}

			public WebElement getLeadSourceDropdown() {
				return leadSourceDropdown;
			}

			public void setLeadSourceDropdown(WebElement leadSourceDropdown) {
				this.leadSourceDropdown = leadSourceDropdown;
			}

			public WebElement getIndustryDropdown() {
				return industryDropdown;
			}

			public void setIndustryDropdown(WebElement industryDropdown) {
				this.industryDropdown = industryDropdown;
			}

			public WebElement getMobileField() {
				return mobileField;
			}

			public void setMobileField(WebElement mobileField) {
				this.mobileField = mobileField;
			}

			public WebElement getSaveButton() {
				return saveButton;
			}

			public void setSaveButton(WebElement saveButton) {
				this.saveButton = saveButton;
			}

}