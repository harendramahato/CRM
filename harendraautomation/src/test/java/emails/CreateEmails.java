package emails;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import object_repository.EmailPage;
import object_repository.LoginPage;


/**
 * Test Script Name : CreateEmails
 *
 * Description:
 * This script automates the process of composing and sending an email
 * from the Email module of the Vtiger CRM application.
 *
 * Application : Vtiger CRM
 * Module      : Email
 * Test Type   : Functional Automation Testing
 * Tool        : Selenium WebDriver
 * Author      : Harendra Mahato
 */

public class CreateEmails {

   public static void main(String[] args) throws IOException, InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8888/index.php?action=Login&module=Users");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			LoginPage lp = new LoginPage(driver);
			EmailPage ep = new EmailPage(driver);

			WebElement usernameField = lp.getUsername();
			WebElement passwordField = lp.getpassword(); 
			WebElement loginButton = lp.getloginbutton();
			usernameField.sendKeys("admin");
			passwordField.sendKeys("manager");
			loginButton.click();
			
		//	driver.findElement(By.name("user_name")).sendKeys("admin");
		//	driver.findElement(By.name("user_password")).sendKeys("manager");
		//	driver.findElement(By.id("submitButton")).click();
		//	driver.findElement(By.linkText("Email")).click();    
			
			ep.getEmaillink().click();
			
		// WebElement compose=driver.findElement(By.cssSelector("//a[text()='Compose']"));
           
		   ep.getComposelink().click();
	         
	        String pid = driver.getWindowHandle();
	        Set<String> oldWindow=driver.getWindowHandles();

	      for(String windowHandle:oldWindow) {
		    if(!windowHandle.equals(pid)) {
			
			driver.switchTo().window(windowHandle);
			break;
		   }	
	       }
	      
	      WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	       System.out.println(driver.getTitle());


	   // WebElement contact=driver.findElement(By.cssSelector("//img[@title='Select']"));
	      
	       ep.getContact().click();

          Set<String> allWindow=driver.getWindowHandles();
         for(String window:allWindow) {
		 if(!oldWindow.contains(window)) {
			
			driver.switchTo().window(window);
			break;
		}	
	    }
	   WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
	   wait1.until(ExpectedConditions.numberOfWindowsToBe(3));
	   System.out.println(driver.getTitle());


	  //driver.findElement(By.xpath("//a[text()='Mary Smith']"))
	   ep.getMarySmithLink().click();

	    Set<String> newwindow=driver.getWindowHandles();

	    for(String windowHandle1:newwindow) {
		if(!windowHandle1.equals(pid)) {
			
			driver.switchTo().window(windowHandle1);
			break;
		 }	
	     }


	  //driver.findElement(By.id("subject"))
	    ep.getSubjectField().sendKeys("test vtiger");
	    

	  //driver.findElement(By.name("Send")).click();
	    ep.getSendButton().click();
	    
	   Thread.sleep(4000);
	  driver.quit();
			
}
		}