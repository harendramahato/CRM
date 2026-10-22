package types_of_exe_parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrgTest {

        @Parameters("broswer")	
	    @Test(groups="reg")
	    public void createOrgTest(String broswer) throws InterruptedException {
	    
        	
    	    WebDriver driver;
    		if (broswer.equals("chrome")) {
    		driver = new ChromeDriver();
    		} else if (broswer.equals("edge")) {
    		driver = new EdgeDriver();
    		} else if (broswer.equals("firefox")) {
    		driver = new FirefoxDriver();
    		} else
    		driver = new ChromeDriver();	
    		
    		System.out.println("Org created");
    		Thread.sleep(3000);
    		driver.quit();
 

        }
//	    @Test(groups="smoke")
//	    public void modifyOrgTest() {
//	        System.out.println("Org modified");
//	    }

//	    @Test(groups={"reg","smoke"})
//	    public void deleteOrgTest() {
//	        System.out.println("Org deleted");
//	    }
	}
