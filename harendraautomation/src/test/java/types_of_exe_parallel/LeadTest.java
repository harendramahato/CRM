package types_of_exe_parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeadTest {
	
	
	@Parameters("broswer")
	@Test(groups={"reg","smoke"})
	public void createLeadTest(String broswer) throws InterruptedException {
	
	    WebDriver driver;
		if (broswer.equals("chrome")) {
		driver = new ChromeDriver();
		} else if (broswer.equals("edge")) {
		driver = new EdgeDriver();
		} else if (broswer.equals("firefox")) {
		driver = new FirefoxDriver();
		} else
		driver = new ChromeDriver();	
		
		System.out.println("Lead created");
		Thread.sleep(3000);
		driver.quit();
	}

	//	@Test(groups="smoke")
//  public void modifyLeadTest() {
//    System.out.println("Lead modified");
//	}
	
//    @Test(groups="reg")
//    public void deleteLeadTest() {
//	 System.out.println("Lead deleted");
		
//	}
}
