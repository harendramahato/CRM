package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPageVerify {
		
		public LeadPageVerify(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		// Actual Last Name
		@FindBy(id = "dtlview_Last Name")
		private WebElement actualLastName;

		// Actual Company
		@FindBy(id = "dtlview_Company")
		private WebElement actualCompanyName;

		// Actual Lead Source
		@FindBy(id = "dtlview_Lead Source")
		private WebElement actualLeadSource;

		public WebElement getActualLastName() {
			return actualLastName;
		}

		public void setActualLastName(WebElement actualLastName) {
			this.actualLastName = actualLastName;
		}

		public WebElement getActualCompanyName() {
			return actualCompanyName;
		}

		public void setActualCompanyName(WebElement actualCompanyName) {
			this.actualCompanyName = actualCompanyName;
		}

		public WebElement getActualLeadSource() {
			return actualLeadSource;
		}

		public void setActualLeadSource(WebElement actualLeadSource) {
			this.actualLeadSource = actualLeadSource;
		}

		public WebElement getActualMobile() {
			return actualMobile;
		}

		public void setActualMobile(WebElement actualMobile) {
			this.actualMobile = actualMobile;
		}

		public WebElement getActualIndustry() {
			return actualIndustry;
		}

		public void setActualIndustry(WebElement actualIndustry) {
			this.actualIndustry = actualIndustry;
		}
		// Actual Mobile
		@FindBy(id = "dtlview_Mobile")
		private WebElement actualMobile;

		// Actual Industry
		@FindBy(id = "dtlview_Industry")
		private WebElement actualIndustry;

	}

