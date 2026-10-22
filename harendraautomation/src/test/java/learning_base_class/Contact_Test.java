package learning_base_class;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Contact_Test extends Practice_Base {
		
		@Test
		public void createContactTest() {
			Reporter.log("create Contact",true);
			Reporter.log("verify Contact",true);
		}

}
