package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	 @FindBy(xpath="//input[@name='username']")      // Data Members(variables)
		private WebElement Username;
		
		@FindBy(xpath="//input[@name='password']")       // Data Members(variables)
		private WebElement Password;
		
		@FindBy(xpath="//button[@type='submit']")         // Data Members(variables)
		private WebElement Login;
		
		
		public LoginPage (WebDriver driver) {        //Constructor
			
			PageFactory.initElements(driver, this);           
		}
	      
		public void SendUsername(String Uname) {          //Method
			
			Username.sendKeys(Uname);
		}
		
	   public void SendPassword(String pwd) {          //Method
			
		   Password.sendKeys(pwd);
		}
	   
	   public void ClickonLoginButton() {          //Method
			
			Login.click();
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
