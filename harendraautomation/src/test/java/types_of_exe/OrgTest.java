package types_of_exe;

import org.testng.annotations.Test;

public class OrgTest {

	    @Test(groups="reg")
	    public void createOrgTest() {
	        System.out.println("Org created");
	    }

	    @Test(groups="smoke")
	    public void modifyOrgTest() {
	        System.out.println("Org modified");
	    }

	    @Test(groups={"reg","smoke"})
	    public void deleteOrgTest() {
	        System.out.println("Org deleted");
	    }
	}
