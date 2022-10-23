package SeleniumFramWork.Tests;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import SeleniumFramWork.PageObjects.CartPageObjects;
import SeleniumFramWork.PageObjects.CheckoutPageObjects;
import SeleniumFramWork.PageObjects.ConfirmationPageObjects;
import SeleniumFramWork.PageObjects.LandingPageObjects;
import SeleniumFramWork.PageObjects.ProductCataloguePageObjects;

public class SubmitOrderTest {
	public static void main (String []args) throws InterruptedException {
		String ProductName="ZARA COAT 3";
	System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Manohar\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	LandingPageObjects LP= new LandingPageObjects(driver);
	LP.goTO();
	LP.Loginapp("manum7792@gmail.com", "Rahul@123");
	ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
		List<WebElement> products=Prod.getProductsList();
	Prod.addProductToCart(ProductName);
	Prod.goToCartPage();
	CartPageObjects CartPage= new CartPageObjects(driver);
 Boolean match=	CartPage.VerifyProductDisplay(ProductName);
 Assert.assertTrue(match);
     CartPage.CheckOut();	
	CheckoutPageObjects CP= new CheckoutPageObjects(driver);
	CP.SelectCountry("India");
	CP.Submit();
	ConfirmationPageObjects Cp = new ConfirmationPageObjects(driver);
	String confirmMessage=	Cp.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	//driver.close();
}
}
