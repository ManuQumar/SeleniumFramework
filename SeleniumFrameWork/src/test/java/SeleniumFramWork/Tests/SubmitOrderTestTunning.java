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
//	public void SubmitOrder(String EmailId , String Password, String ProductName) throws IOException, InterruptedException {
	
	
	public void SubmitOrder(HashMap<String , String> input) throws IOException, InterruptedException {

	// here we drive the parameters using HashMap so commenting the above line	
		// Here I know we should hit the Login Page so I declared it in BaseTest LauchApplication method
		// as we extending the BaseTest we can have the access of Parent variables 
		//As we using testNG method with the help of @BeforeTest annotation we can comment the below line
//	LandingPageObjects LP=	LaunchApplication();
		
		
	LP.Loginapp(input.get("EmailId"),input.get("Password"));
	ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
		List<WebElement> products=Prod.getProductsList();
	Prod.addProductToCart(input.get("ProductName"));
	Prod.goToCartPage();
	CartPageObjects CartPage= new CartPageObjects(driver);
 Boolean match=	CartPage.VerifyProductDisplay(input.get("ProductName"));
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
	System.out.println("Done!");
	}
	
	// here Implementing testNG data Provider to run the test with mutiple set of Data
	@DataProvider
	public Object[][] getData() {
		HashMap<String, String> HMap= new HashMap<String, String>();
		HMap.put("EmailId", "manum7792@gmail.com");
		HMap.put("Password", "Rahul@123");
		HMap.putIfAbsent("ProductName", "ZARA COAT 3");
		HashMap<String,String> HMap1 = new HashMap<String,String>();
		HMap1.put("EmailId", "paul@gmail.com");
		HMap1.put("Password", "Paul@321");
		HMap1.put("ProductName", "ADIDAS ORIGINAL");
		return	new Object[][] { {HMap }, {HMap1}};
	//	return	new String[][] { {"manum7792@gmail.com" ,"Rahul@123","ZARA COAT 3" }, {"paul@gmail.com","Paul@321","ADIDAS ORIGINAL"}};
	}
	
}
