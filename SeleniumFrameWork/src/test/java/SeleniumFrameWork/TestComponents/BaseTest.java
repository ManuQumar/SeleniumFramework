package SeleniumFrameWork.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import SeleniumFramWork.PageObjects.LandingPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPageObjects LP;
	public WebDriver initializeDriver() throws IOException {
		Properties Pro = new Properties();
		// use can short this path ( System.getProperty("user.dir")+\\src\\test\\java\\SeleniumFrameWork\\Resources\\GlobalData.properties;
		FileInputStream FIS= new FileInputStream("C:\\Users\\Manohar\\git\\SeleniumFramework\\SeleniumFrameWork\\src\\test\\java\\SeleniumFrameWork\\Resources\\GlobalData.properties");
		Pro.load(FIS);
	String browserName=	Pro.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://facebook.com");
	}
	else if(browserName.equalsIgnoreCase("edge")) {
		
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	
	}
	public LandingPageObjects LaunchApplication() throws IOException {
		 driver= initializeDriver();
		 LP= new LandingPageObjects(driver);
		LP.goTO();
		return LP;
	}
}
