package SeleniumFramWork.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPageObjects extends AbstractComponent{
	WebDriver driver;
	public ConfirmationPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver , this);
	}
 @FindBy(css =".hero-primary")
 WebElement confirmationMessage;
 
 public String getConfirmationMessage() {
	 return confirmationMessage.getText();
 }
}
