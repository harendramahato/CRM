package learning_reports;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.edge.EdgeDriver;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class Vtiger {

	    public static void main(String[] args) {

	        // --- Report Setup ---
	        ExtentSparkReporter spark = new ExtentSparkReporter("./adv_report/rep01.html");

	        spark.config().setDocumentTitle("Vtiger CRM Report");
	        spark.config().setReportName("Vtiger Test Suite");
	        spark.config().setTheme(Theme.DARK);

	        ExtentReports report = new ExtentReports();
	        report.attachReporter(spark);

	        report.setSystemInfo("Browser", "Edge");
	        report.setSystemInfo("OS", "Windows 11");
	        report.setSystemInfo("Application", "Vtiger CRM");
	        report.setSystemInfo("URL", "http://localhost:8888/index.php");


	        // ========== TEST 1: Login ==========
	        ExtentTest loginTest = report.createTest("Vtiger Login");

	        WebDriver driver = null;

	        try {

	            // --- Driver Setup ---
	            driver = new EdgeDriver();
	            loginTest.log(Status.INFO,"Browser launched successfully");

	            driver.manage().window().maximize();
	            loginTest.log(Status.INFO,"Browser window maximized successfully");

	            driver.manage().timeouts() .implicitlyWait(Duration.ofSeconds(10));
                loginTest.log(Status.INFO, "Wait configured to 10 seconds");


	            // --- Navigate to Application ---
	            driver.get("http://localhost:8888/index.php");

	            loginTest.log(Status.INFO,
	                    "Navigated to Vtiger CRM login page");


	            // --- Enter Username ---
	            driver.findElement(By.name("user_name")).sendKeys("admin");
                loginTest.log(Status.INFO, "Entered username successfully");


	            // --- Enter Password ---
	            driver.findElement(By.name("user_password")).sendKeys("manager");
                loginTest.log(Status.INFO,"Entered password successfully");


	            // --- Click Login Button ---
	            driver.findElement(By.id("submitButton")).click();

	            loginTest.log(Status.INFO,"Clicked login button");


	            // --- Validate Login ---
	            if (driver.getCurrentUrl().contains("Home")) {

	                loginTest.log(Status.PASS,"Login successful - redirected to Vtiger Home Page");
                    loginTest.log(Status.INFO,"Now, we are on the Vtiger Home Page");

	            } else {

	                loginTest.log(Status.FAIL,"Login failed - not redirected to Home Page. URL: " + driver.getCurrentUrl());
	            }

	        } catch (Exception e) {

	            loginTest.log(Status.FAIL,
	                    "Test execution failed: " + e.getMessage());

	        } finally {

	            // --- Browser Close ---
	            if (driver != null) {
	                driver.quit();

	                loginTest.log(Status.INFO,
	                        "Browser closed successfully");
	            }

	            // --- Generate Report ---
	            report.flush();
	        }
	    }
	}
