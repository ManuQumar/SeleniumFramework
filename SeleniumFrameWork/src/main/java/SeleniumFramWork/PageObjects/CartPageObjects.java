package SeleniumFramWork.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPageObjects extends AbstractComponent {
	WebDriver driver;
	public CartPageObjects(WebDriver driver) {
		super(driver);
		this.driver =driver;
		PageFactory.initElements( driver, this);
	}
	By ProductToLoad= By.cssSelector(".itemImg");
	//
	@FindBy(css=".totalRow button")
	WebElement checkout;
	@FindBy(css = ".cartSection h3")
	private List<WebElement> productsTitles;
//	@FindBy(css = ".cartSection h3")
//	private List<WebElement> cartProducts;

	public Boolean VerifyProductDisplay(String ProductName) {
		Boolean match= productsTitles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(ProductName));
		return match;
//		public Boolean VerifyProductDisplay(String productName) {
//			Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
//			return match;
//
//		}
	}
	public void CheckOut() {
		WaitForTheElementsToLoad(ProductToLoad);
		checkout.click();
		//return new
	}
}
