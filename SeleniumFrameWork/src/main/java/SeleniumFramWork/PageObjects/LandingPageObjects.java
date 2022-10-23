package SeleniumFramWork.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {
	WebDriver driver;
	public LandingPageObjects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
//	By UserId= By.id("userEmail");
//	By Password = By.id("userPassword"); 
			// we can use page factory method to declare the objects using findby
	@FindBy(id="userEmail")
	WebElement Email;
	@FindBy(id="userPassword")
	WebElement Password;
	@FindBy(id="login")
	WebElement Submit;
	
	public void Loginapp(String EmailId, String Pswrd) {
		Email.sendKeys(EmailId);
		Password.sendKeys(Pswrd);
		Submit.click();
		
	}
	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");
	
	}
//	public void UserId() {
//		driver.findElement(UserId);
//	}
//	public void Password() {
//		driver.findElement(Password);
//	}
}
