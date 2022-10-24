package SeleniumFramWork.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPageObjects {
	WebDriver driver;
	public OrderPageObjects(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements( driver, this);
	}
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	public Boolean VerifyOrderDisplay(String ProductName) {
		Boolean match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(ProductName));
		return match;

	}
}
