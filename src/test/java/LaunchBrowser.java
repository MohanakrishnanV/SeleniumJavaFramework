import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LaunchBrowser {
	public static void main(String[] args) 
	
	{
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		
		// Browser driver Path set up
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\eclipse-workspace\\SeleniumJavaFramework\\drivers\\chromedriver.exe");
				
		//Browser object declaration
		WebDriver driver = new ChromeDriver();
		
		//Maximize current window
		driver.manage().window().maximize();
		
		// Navigate to a Web site
		driver.get("https://www.myemploywise.com/asperm/servlet/ggs.erm.servlet.setup3.LoginS?customer_code=excelencia");
		extent.createTest("Application URL Launch")
		  .log(Status.PASS, "The Employwise web application Successfully launched in the Browser, and it passed!");
		
				
		//Entering the Username in the text box
		driver.findElement(By.id("User_Name")).sendKeys("ECPL0546");
		extent.createTest("Employee Code")
		  .log(Status.PASS, "The Employee code successfully entered in the Text box, and it passed!");
		
		
		//Entering the Password in the text box
		driver.findElement(By.id("Password")).sendKeys("Excel.123");
		extent.createTest("Employee Password")
		  .log(Status.PASS, "The Employee Password successfully entered in the Text box, and it passed!");
		
		
		
		//Clicking on the Login button
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]/span[1]/input[1]")).click();
		extent.createTest("Login button")
		  .log(Status.PASS, "Login button successfully clicked in the Login page, and it passed!");
		
		
		//Clicking on the Compensation from top menu bar
		driver.findElement(By.id("reimbursementListMenu")).click();
		extent.createTest("Compensation")
		.log(Status.PASS, "Compensation tab successfully clicked from the top menu bar, and it passed!");
		
				
		
		//Clicking on the Logout link
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		extent.createTest("Logout")
		.log(Status.PASS, "Logout clicked successfully, and it passed!");


		
		
		
		extent.flush();
		
	}

}
