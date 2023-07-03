package SeleniumFramWork.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFramWork.PageObjects.CartPageObjects;
import SeleniumFramWork.PageObjects.CheckoutPageObjects;
import SeleniumFramWork.PageObjects.ConfirmationPageObjects;
import SeleniumFramWork.PageObjects.LandingPageObjects;
import SeleniumFramWork.PageObjects.OrderPageObjects;
import SeleniumFramWork.PageObjects.ProductCataloguePageObjects;
import SeleniumFrameWork.TestComponents.BaseTest;

public class SubmitOrderTestTunning extends BaseTest{
	String ProductName="ZARA COAT 3";
	@Test(dataProvider= "getData" , groups={"purchaseOrder"})
	// passing the strings and grouping to run this test Individually
	public void SubmitOrder(String EmailId , String Password, String ProductName) throws IOException, InterruptedException {

	LP.Loginapp(EmailId,Password);
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
	System.out.println(confirmMessage);
}
	@Test(dependsOnMethods={"SubmitOrder"})
	public void OrderHistory( ) {
		LP.Loginapp("manum7792@gmail.com", "Rahul@123");
		ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
		Prod.goToOrderPage();
		OrderPageObjects OrdersPage= new OrderPageObjects(driver);
	Assert.assertTrue(OrdersPage.VerifyOrderDisplay(ProductName));
	System.out.println("Checked Order History!");
	}
	
	// here Implementing testNG data Provider to run the test with mutiple set of Data
	@DataProvider
	public String[][] getData() {
		
		return	new String[][] { {"manum7792@gmail.com" ,"Rahul@123","ZARA COAT 3" }, {"paul@gmail.com","Paul@321","ADIDAS ORIGINAL"}};
	}
	
}
