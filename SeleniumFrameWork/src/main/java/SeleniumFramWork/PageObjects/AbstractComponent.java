package SeleniumFramWork.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
		WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver ,this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	
	public void WaitForTheElementsToLoad(By findBy) {
	WebDriverWait Wait= new WebDriverWait(driver, Duration.ofSeconds(5)); 
	Wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
	public void goToCartPage() {
		cartHeader.click();
	}
	public void WaitForElementTODisapper(WebElement Ele) throws InterruptedException  {
		Thread.sleep(1000);
//		WebDriverWait Wait= new WebDriverWait(driver, Duration.ofSeconds(1)); 
//		Wait.until(ExpectedConditions.invisibilityOf(Ele));
	}

}
