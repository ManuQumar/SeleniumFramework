package SeleniumFramWork.PracticeFrameWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Manohar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.navigate().to("https://rahulshettyacademy.com/client/auth/login");
		driver.get("https://rahulshettyacademy.com/client");
		String Email ="manum7792@gmail.com";
		String Password ="Rahul@123";
		driver.findElement(By.id("userEmail")).sendKeys(Email);
		driver.findElement(By.id("userPassword")).sendKeys(Password);
		driver.findElement(By.id("login")).click();	
		// To Valid Successful login 
//	System.out.println(driver.getTitle());
		String Item ="IPHONE 13 PRO";
	Assert.assertEquals(driver.getTitle(), "Let's Shop");
	WebDriverWait Wait= new WebDriverWait(driver, Duration.ofSeconds(10)); 
//	Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> Products=driver.findElements(By.cssSelector(".mb-3"));
	WebElement Prod=	Products.stream().filter(Product->
	Product.findElement(By.cssSelector("b")).getText().equals(Item)).findFirst().orElse(null);
				Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
				
				Wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
				Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//				WebElement element = driver.findElement(By.cssSelector("[routerlink*='cart']"));
//
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//
//				js.executeScript("argument[0].click();", element);
					List<WebElement> CardProducts=	driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean ProdMatch=			CardProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(Item));
		Assert.assertTrue(ProdMatch);
		System.out.println("I am exicuted till 53 line");
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		Actions Payment= new Actions(driver);
		Payment.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		List<WebElement> AutoSuggest =driver.findElements(By.cssSelector(".ta-item"));
		driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
//		for( WebElement DropDown : AutoSuggest) {
//			DropDown.getText().equalsIgnoreCase("India");
//			DropDown.click();
//			
//		}
		driver.findElement(By.cssSelector(".action__submit")).click();
		String Order_Confir_MSG=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(Order_Confir_MSG, "THANKYOU FOR THE ORDER.");
		System.out.println("End to End Login PipeLine is executed ");
	}

}
