package TestPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pomPackage.LoginPage;

public class TestLogin {

	WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		
		//System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe\\");
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				driver=new ChromeDriver(option);
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@Test
	public void onetest1() {
		LoginPage login= new LoginPage(driver);
	       login.SendUsername("Admin");
	       login.SendPassword("admin123");
	       login.ClickonLoginButton();
	       String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	       String ActualURL = driver.getCurrentUrl();
	       Assert.assertEquals(ActualURL, ExpectedURL);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
