package vT.Automaton;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Automation01 {

	static ExtentReports ExtentReportsOBJ;
	static	ExtentTest extent;

	public static void main(String[] args) {

		ExtentReportsOBJ=new ExtentReports();

		File file=new File("Reports");
		if(file.exists()==false) {
			file.mkdir();
		}

		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+"reports.html");
		ExtentReportsOBJ.attachReporter(spark);
		extent=ExtentReportsOBJ.createTest("MyFirstTest");

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions Ops =new ChromeOptions();
		Ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver =new ChromeDriver(Ops);

		extent.log(Status.INFO, " SuccessFully Browser Lanched ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("http://localhost:8888");
		extent.log(Status.INFO, " SuccessFully URL Opened ");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		extent.log(Status.INFO, "SuccessFully User Name is Entered ");

		driver.findElement(By.name("user_password")).sendKeys("admin");
		extent.log(Status.INFO, " SuccessFully User Password is Entered ");

		driver.findElement(By.name("Login")).click();
		extent.log(Status.INFO, " SuccessFully Cicked on Login ");

		driver.manage().window().maximize();
		driver.findElement(By.linkText("Marketing")).click();
		extent.log(Status.INFO, " SuccessFully Cicked on Marketing button ");

		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		extent.log(Status.INFO, " SuccessFully Cicked on Create Campaign button ");

		driver.findElement(By.xpath("//input[@name=\"campaignname\"]")).sendKeys(" vishal singh ");
		extent.log(Status.INFO, " Campaignname is SuccessFully inter on campaignnameTextBox ");

		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[2]")).click();
		extent.log(Status.INFO, " SuccessFully perform on the  Save button ");

		//String  web= driver.findElement(By.xpath("//td[@id=\"mouseArea_Campaign Name\"]")).getText();
		//	 System.out.println(web);
		//	 String text ="vishal singh";
		//		if (web.equalsIgnoreCase(text)) {
		//			System.out.println("Expected- ( vishal singh ) and Actual- ( vishal singh ) Text is match so , it paas ");
		//			
		//		}else {
		//			System.out.println("Expected- ( vishal singh ) and Actual- ( vishal singh ) Text is missmatch so , it failed ");
		//
		//		}

		ExtentReportsOBJ.flush();

		//driver.quit();
 
	}
}







