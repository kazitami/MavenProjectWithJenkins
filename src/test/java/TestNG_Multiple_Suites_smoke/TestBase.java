package TestNG_Multiple_Suites_smoke;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	
	public TestBase() throws Exception {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/TestNG_Multiple_Suites_smoke/config.properties");
		prop.load(ip);
	
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		
		if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox"))
		{
			driver = new FirefoxDriver();
		}else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();	
		}else 
		{
			System.out.println("None of the browser matches");
		}
			
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(400));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		
		return driver;
	}
	
	public static String emailStamp() {
		Date date = new Date();
		String em = date.toString().replace(" ", "_").replace(":", "_");
		return "seleniumpanda"+em+"@gamil.com";
	}
	
}
