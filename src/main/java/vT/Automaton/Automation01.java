package vT.Automaton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Automation01 {
 
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions Ops =new ChromeOptions();
		Ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver =new ChromeDriver(Ops);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		driver.get("http://localhost:8888");	
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.name("Login")).click();
		System.err.println(" Login is successful ");
		driver.findElement(By.linkText("Marketing")).click();
	
		
		
		
		
		
		
		
		
	}
	}







