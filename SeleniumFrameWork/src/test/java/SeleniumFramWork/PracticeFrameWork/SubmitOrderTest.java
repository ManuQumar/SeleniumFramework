package SeleniumFramWork.PracticeFrameWork;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumFramWork.PageObjects.AbstractComponent;
import SeleniumFramWork.PageObjects.LandingPageObjects;
import SeleniumFramWork.PageObjects.ProductCataloguePageObjects;

public class SubmitOrderTest {
	public static void main (String []args) {
		String ProductName="IPHONE 13 PRO";
	System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Manohar\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	LandingPageObjects LP= new LandingPageObjects(driver);
	LP.goTO();
	LP.Loginapp("manum7792@gmail.com", "Rahul@123");
	ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
		List<WebElement> products=Prod.getProductsList();
	Prod.addProductToCart(ProductName);
	AbstractComponent AC= new AbstractComponent(driver);
	AC.goToCartPage();
}
}
