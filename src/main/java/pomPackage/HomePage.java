package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="(//a[@class='oxd-main-menu-item'])[1]")      // Data Members(variables)
	private WebElement Admin;
	
	@FindBy(xpath="(//a[@class='oxd-main-menu-item'])[2]")      // Data Members(variables)
	private WebElement PIM;
	
	@FindBy(xpath="(//a[@class='oxd-main-menu-item'])[3]")      // Data Members(variables)
	private WebElement Leave;
	
	@FindBy(xpath="(//a[@class='oxd-main-menu-item'])[4]")      // Data Members(variables)
	private WebElement Time;
	
	@FindBy(xpath="(//a[@class='oxd-main-menu-item'])[5]")      // Data Members(variables)
	private WebElement Recruitment;
	
	
	public HomePage (WebDriver driver) {                        //Constructor
		
		PageFactory.initElements(driver, this);           
	}
	
	public boolean verifyAdmininoption() {    //method
		
		boolean result = Admin.isDisplayed();
		return result;
		}
	
	   public boolean verifyPIMinoption() {                 //method
		   
		boolean result = PIM.isDisplayed();
		return result;
		}
	
	  public boolean verifyLeaveinoption() {                 //method
		  
		boolean result= Leave.isDisplayed();
		return result;
		}
	
	public boolean verifyTimeinoption() {                 //method
		
		boolean result= Time.isDisplayed();
		return result;
		}
	
	public boolean verifyRecruitmentinoption() {                 //method
		
		boolean result= Recruitment.isDisplayed();
		return result;
		
         
	}

	
	
}
