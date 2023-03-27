package testUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticBrowser {
	static WebDriver driver;
	
	
	public static WebDriver Browsermethod (String browser, String URL, int timeout )
    {
		   if(browser.equalsIgnoreCase("chrome"))
		   {
			   ChromeOptions option=new ChromeOptions();
			   option.addArguments("--remote-allow-origins=*");
			   
			   WebDriverManager.chromedriver().setup();
			   driver = new ChromeDriver(option);
		   }
		   else if(browser.equalsIgnoreCase("firefox")) 
		   {
			   WebDriverManager.firefoxdriver().setup();
			   driver = new FirefoxDriver();
			   
		   }
		   else if(browser.equalsIgnoreCase("edge"))
		   {
			   WebDriverManager.edgedriver().setup();
			   driver = new EdgeDriver();
		   }
 	   
 	        //driver.get("https://www.facebook.com/");
 	            driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
				return driver;
	}

}
