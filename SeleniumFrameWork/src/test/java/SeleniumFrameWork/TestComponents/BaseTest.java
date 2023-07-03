package SeleniumFrameWork.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import SeleniumFramWork.PageObjects.LandingPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public ChromeOptions options;
	public LandingPageObjects LP;
	public WebDriver initializeDriver() throws IOException {
		Properties Pro = new Properties();
		// use can short this path ( System.getProperty("user.dir")+\\src\\test\\java\\SeleniumFrameWork\\Resources\\GlobalData.properties;
		FileInputStream FIS= new FileInputStream("C:\\Users\\Manohar\\git\\SeleniumFramework\\SeleniumFrameWork\\src\\test\\java\\SeleniumFrameWork\\Resources\\GlobalData.properties");
		Pro.load(FIS);
	String browserName=	Pro.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true);
		 driver = new ChromeDriver(options);
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		 driver = new ChromeDriver(options);
		 driver.get("https://facebook.com");
	}
	else if(browserName.equalsIgnoreCase("edge")) {
		
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
	
	}
	// derive the driver from ITestlisterns
	public String getScreenshot(String testCaseName , WebDriver driver) throws IOException {
		TakesScreenshot TS= (TakesScreenshot)driver;
	File source=	TS.getScreenshotAs(OutputType.FILE);
	File file= new File(System.getProperty("user.dir") +"//reports// "+testCaseName+ ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir" )+"//reports// " +testCaseName+ ".png";
	}
	// these Before Method and After method are common so we use testNG feature of alwaysRun=true
	// if you want run for all the groups test cases then this Run=true is used as in groups concept it doesn't have knowledge to get execute this beforeMethod or aftermethod
	@BeforeMethod(alwaysRun=true)
	//@BeforeTest(alwaysRun=true)
	public LandingPageObjects LaunchApplication() throws IOException {
		 driver= initializeDriver();
		 LP= new LandingPageObjects(driver);
		LP.goTO();
		return LP;
	}
	@AfterMethod(alwaysRun=true)
	public void TearDown() {
	driver.close();
}
	
}