package SeleniumFramWork.PracticeFrameWork;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MYTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	//	WebDriverManager.chromedriver().setup();
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
		List<WebElement> Products=driver.findElements(By.xpath("//div[@class='card-body']//h5"));
		//div.card-body button:last-of-type
		for(WebElement Prod: Products) {
			if(Prod.getText().equals("IPHONE 13 PRO")){
				driver.findElement(By.xpath("//div[@class='card-body']//button[2]")).click();
				//Prod.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
			break;
			}
//			else {
//				driver.close();
//			}
			}
	}
}

