package TestPackage;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomPackage.HomePage;
import pomPackage.LoginPage;
import testUtility.ReadFiles;
import testUtility.StaticBrowser;

public class TestHome {

    WebDriver driver;
       @Parameters({"browser"})
	
	@BeforeTest
	public void beforeTest(String browser)
       {
		  driver = StaticBrowser.Browsermethod(browser, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login", 10);
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
	public void onetest2() throws InterruptedException, EncryptedDocumentException, IOException {
		SoftAssert s= new SoftAssert();
		LoginPage login= new LoginPage(driver);
	       login.SendUsername(ReadFiles.fetchDataFromExcel(1, 0));
	       login.SendPassword(ReadFiles.fetchDataFromExcel(1, 1));
	       login.ClickonLoginButton();
	       Thread.sleep(1000);
	       String ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	       String ActualURL = driver.getCurrentUrl();
	       Assert.assertEquals(ActualURL, ExpectedURL);   //pass
	       
	       HomePage home= new HomePage(driver);
	       boolean result1 = home.verifyAdmininoption();
	       s.assertTrue(result1, "Admin option is present");
	       
	       System.out.println("Admin option is present");
	       
	       boolean result2 = home.verifyPIMinoption();
	       s.assertTrue(result2, "PIM option is present");
	       
	       boolean result3 = home.verifyLeaveinoption();
	       s.assertTrue(result3, "leave option is present");
	       
	       boolean result4 = home.verifyRecruitmentinoption();
	       s.assertTrue(result4, "Recruitment option is present");
	       
	       boolean result5 = home.verifyTimeinoption();
	       s.assertTrue(result5, "Time option is present"); 
	       s.assertAll();
		
		//System.out.println("browser launched");
	       
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
		
		//driver.quit();
	}
	
}
