package SeleniumFramWork.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageObjects extends AbstractComponent {
	WebDriver driver;
	public CheckoutPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement Country;
	@FindBy(css= ".action__submit")
	WebElement PlaceOrder;
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement SelectCountry;
	By results= By.cssSelector(".ta-item");
	public void SelectCountry(String CountryName) {
		Actions Payment= new Actions(driver);
		Payment.sendKeys(Country, CountryName).build().perform();
		WaitForTheElementsToLoad(results);
		SelectCountry.click();
	}
	public void Submit() {
		PlaceOrder.click();

	}
}
