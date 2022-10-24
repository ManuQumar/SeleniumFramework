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
import SeleniumFramWork.PageObjects.OrderPageObjects;
import SeleniumFramWork.PageObjects.ProductCataloguePageObjects;
import SeleniumFrameWork.TestComponents.BaseTest;

public class SubmitOrderTestTunning extends BaseTest{
	String ProductName="ZARA COAT 3";
	@Test
	public void SubmitOrder() throws IOException, InterruptedException {
		
		// Here I know we should hit the Login Page so I declared it in BaseTest LauchApplication method
		// as we extending the BaseTest we can have the access of Parent variables 
		//As we using testNG method with the help of @BeforeTest annotation we can comment the below line
//	LandingPageObjects LP=	LaunchApplication();
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
	System.out.println(confirmMessage);
}
	@Test(dependsOnMethods={"SubmitOrder"})
	public void OrderHistory() {
		LP.Loginapp("manum7792@gmail.com", "Rahul@123");
		ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
		Prod.goToOrderPage();
		OrderPageObjects OrdersPage= new OrderPageObjects(driver);
	Assert.assertTrue(OrdersPage.VerifyOrderDisplay(ProductName));
	System.out.println("Done!");
	}
}
