package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	    
	    public EmailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	    }
	    // Email link
        @FindBy(linkText="Email")
        private WebElement Emaillink;
    
        // Compose link
         @FindBy(xpath="//a[text()='Compose']")
        private WebElement Composelink;
     
         // Select contact button 
         //@FindBy(css="//img[@title='Select']")
         @FindBy(css="themes/softed/images/select.gif")
        private WebElement Contact;
    
        // Mary Smith contact
        @FindBy(xpath = "//a[text()='Mary Smith']")
        private WebElement marySmithLink;
    
        // Subject field
        @FindBy(id = "subject")
        private WebElement subjectField;
    
        // Send button 
        @FindBy(name = "Send")
        private WebElement sendButton;

		public WebElement getEmaillink() {
			return Emaillink;
		}

		public WebElement getComposelink() {
			return Composelink;
		
		}

		public WebElement getContact() {
			return Contact;
		
		}

		public WebElement getMarySmithLink() {
			return marySmithLink;
		
		}

		public WebElement getSubjectField() {
			return subjectField;
	
		}

		public WebElement getSendButton() {
			return sendButton;
	
		}
        
}
