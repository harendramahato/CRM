package learning_base_class;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Practice_Base {
    @BeforeClass
    public void setUp() {
    	System.out.println("Open Broswer");
    }
	
    @BeforeMethod
    public void login() {
    	System.out.println("Login");

    }

    @AfterMethod
    public void logout() {
    	System.out.println("Logout");
    }
    
    @AfterClass
    public void tearDown() {
    	System.out.println("TearDown");
    }
    
}

