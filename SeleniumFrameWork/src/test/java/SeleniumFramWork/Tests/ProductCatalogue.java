package SeleniumFramWork.Tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import SeleniumFramWork.PageObjects.ProductCataloguePageObjects;

public class ProductCatalogue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Manohar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ProductCataloguePageObjects Prod= new ProductCataloguePageObjects(driver);
	List<WebElement> Products=	Prod.getProductsList();
	
	}

}
