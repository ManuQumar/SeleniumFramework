package SeleniumFramWork.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFramWork.PageObjects.CartPageObjects;
import SeleniumFramWork.PageObjects.CheckoutPageObjects;
import SeleniumFramWork.PageObjects.ConfirmationPageObjects;
import SeleniumFramWork.PageObjects.LandingPageObjects;
import SeleniumFramWork.PageObjects.ProductCataloguePageObjects;
import SeleniumFrameWork.TestComponents.BaseTest;

public class SubmitOrderTestTunning extends BaseTest{
	@Test
	public void SubmitOrder() throws IOException, InterruptedException {
		String ProductName="ZARA COAT 3";
	LandingPageObjects LP=	LaunchApplication();
	LP.Loginapp("manum7792@gmail.com", "Rahul@123");
	ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
		List<WebElement> products=Prod.getProductsList();
	Prod.addProductToCart(ProductName);
	Prod.goToCartPage();
	CartPageObjects CartPage= new CartPageObjects(driver);
 Boolean match=	CartPage.VerifyProductDisplay(ProductName);
    Assert.assertTrue(match);
   //  Assert.assertFalse(match);
 //    Assert.assertEquals(ProductName, ProductName);
System.out.println("I am on 41 line");
	CartPage.CheckOut();
	CheckoutPageObjects CP= new CheckoutPageObjects(driver);
	CP.SelectCountry("India");
	CP.Submit(); 
	ConfirmationPageObjects Cp = new ConfirmationPageObjects(driver);
	String confirmMessage=	Cp.getConfirmationMessage();
	System.out.println(confirmMessage);
	driver.close();
}

}
