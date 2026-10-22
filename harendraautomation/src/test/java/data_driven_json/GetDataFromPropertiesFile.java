      package data_driven_json;

		import java.io.FileReader;
		import java.io.IOException;
		import org.json.simple.JSONObject;
		import org.json.simple.parser.JSONParser;
		import org.json.simple.parser.ParseException;

		public class GetDataFromPropertiesFile {

			public static void main(String[] args) throws IOException, ParseException {
				
				
				
		        // Step 1: Create JSONParser object
				
		        JSONParser parser = new JSONParser();
		        
		        // Step 2: Pass JSON file path
		        
		        FileReader reader = new FileReader("./src/test/resources/commondata.json");
		        
		        // Step 3: Parse JSON file
		        Object obj = parser.parse(reader);
		        
		        
		        // Step 4: Convert object into JSONObject
		        JSONObject jsonObject = (JSONObject) obj;
		        
		        
		        // Step 5: Read data using key
		        String broswer = (String) jsonObject.get("bro");
		        String url = (String) jsonObject.get("url");
		        String username = (String) jsonObject.get("username");
		        String password = (String) jsonObject.get("password");
		       
		       
		        
		        
		        // Step 6: Print data
		        System.out.println(broswer);
		        System.out.println(url);
		        System.out.println(username);
		        System.out.println(password);
		    }
		}
				

