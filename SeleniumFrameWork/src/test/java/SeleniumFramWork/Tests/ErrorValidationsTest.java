package SeleniumFramWork.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFramWork.PageObjects.CartPageObjects;
import SeleniumFramWork.PageObjects.CheckoutPageObjects;
import SeleniumFramWork.PageObjects.ConfirmationPageObjects;
import SeleniumFramWork.PageObjects.ProductCataloguePageObjects;
import SeleniumFrameWork.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
	//String ProductName ="ZARA COAT 3";
// here to add the grouping annotation we created another XML as well to test it	
@Test (groups={"ErrorHandling"})
public void LogInErrorValidations() {
	
	//here with the help of beforeMethod annotation we hit the desired site by running till this line
	LP.Loginapp("manasa7792@gmail.com", "Rahul@123");
	Assert.assertEquals(LP.LoginValidation(), "Incorrect email or password.");
	System.out.println("I am done");
}
@Test
public void ProductErrorvalidation() throws InterruptedException  {
	String ProductName="ZARA COAT 3";
	LP.Loginapp("manum7792@gmail.com", "Rahul@123");
	ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
		List<WebElement> products=Prod.getProductsList();
	Prod.addProductToCart(ProductName);
	Prod.goToCartPage();
	CartPageObjects CartPage= new CartPageObjects(driver);
 Boolean match=	CartPage.VerifyProductDisplay("ZARA COAT33");
 Assert.assertFalse(match);
}
}
