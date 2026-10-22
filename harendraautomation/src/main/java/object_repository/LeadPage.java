
package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	
	public LeadPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Leads")
	private WebElement leadlink;
	
	@FindBy(css= "img[alt='Create Lead...']")
	private WebElement CreateLead;
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement profile;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOut;
	
	
	public WebElement getLeadsLink() {
		return leadlink;
	}
	
	public WebElement getCreateLead() {
		return CreateLead;
    }
	
	public WebElement getSignOut() {
		return SignOut;
	
	}
	public WebElement getprofile() {
		return profile;
	}
	



	}

