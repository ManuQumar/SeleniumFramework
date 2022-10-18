package SeleniumFramWork.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCataloguePageObjects extends AbstractComponent{
	WebDriver driver;
	public ProductCataloguePageObjects(WebDriver driver){
		super(driver);
		this.driver= driver;
		PageFactory.initElements( driver , this);
	}
	//List<WebElement> Products=driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> Products;
	@FindBy(css=".ng-animating")
	WebElement Invisible;
	// we can declare here without hardcoding like WaitForTheElementsToLoad(By.cssSelector(".mb-3"));
	By ProductToLoad= By.cssSelector(".mb-3");
	By AddToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage =By.cssSelector("#toast-contain");
	public List<WebElement> getProductsList() 
	{
		WaitForTheElementsToLoad(ProductToLoad);
		return Products;
	}
	//	WebElement Prod=	Products.stream().filter(Product->
	//Product.findElement(By.cssSelector("b")).getText().equals(Item)).findFirst().orElse(null); this we are writing as
	public WebElement getProductsByName(String productName) {
		WebElement Prod= getProductsList().stream().filter(Product->
			Product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
			return Prod;
	}
	//		Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); this we are writing as
	public void addProductToCart(String productName){
		WebElement Prod= getProductsByName(productName);
		Prod.findElement(AddToCart).click();
		WaitForTheElementsToLoad(toastMessage);
		WaitForElementTODisapper(Invisible);
		
	}
}
