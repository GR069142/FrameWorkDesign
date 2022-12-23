package ValueLabs.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ValueLabs.PageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public ChromeOptions options;
	
	public WebDriver initializeDriver() throws IOException

	{
		Properties prop = new Properties();
		 
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//ValueLabs//Resources//GlobalData.properties");
		prop.load(fis);
		
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\R Girija\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();

		} 
			else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 

			else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		return driver;

	}
	
	public LandingPage launchApplication() throws IOException
	{
		
		 driver = initializeDriver();
		 landingPage = new LandingPage(driver);
		 landingPage.goTo();
		 return landingPage;
	
		
	}
	
	
}
