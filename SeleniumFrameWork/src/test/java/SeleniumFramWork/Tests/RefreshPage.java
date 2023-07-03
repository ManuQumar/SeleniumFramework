package SeleniumFramWork.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	//	WebDriver driver = new ChromeDriver(options);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://nasdaily.com");
		driver.manage().window().maximize();
		driver.get(driver.getCurrentUrl());
		driver.navigate().refresh();
	}

}
