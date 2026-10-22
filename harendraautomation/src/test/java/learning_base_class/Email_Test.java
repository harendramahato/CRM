package learning_base_class;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Email_Test extends Practice_Base {
		
		@Test
		public void createContactTest() {
			Reporter.log("create Email",true);
			Reporter.log("verify Email",true);
		}

}
