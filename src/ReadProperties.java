import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileCacheImageInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadProperties {
	static WebDriver driver;


	public static void main(String[] args) throws IOException {
		
		Properties prop= new Properties();
		FileInputStream ip = new FileInputStream ("C:\\Users\\manjinderk\\workspace\\Task2\\info.properties");
		prop.load(ip);
		
		String BrowserName = prop.getProperty("Browser");
		System.out.println("Browser Name: " +BrowserName);
		
		String UrlName = prop.getProperty("Url");
		System.out.println("Url Name: " +UrlName);
		
		if (BrowserName.equals("Chrome"))
			{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\manjinderk\\workspace\\Task2\\Drivers\\chromedriver83.exe");
	    	
			//ChromeOptions options = new ChromeOptions();
		
			driver = new ChromeDriver();
	    	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			
			String URL = prop.getProperty("Url");
			
				driver.manage().window().maximize();
				driver.get(URL);
				System.out.println("Launch gmail URL: ");
	        }
	        else if (BrowserName.equals("FF"))
	        {	
	        System.setProperty("webdriver.gecko.driver","D:\\Firefox\\geckodriver.exe");
	    	System.out.println("Launch app Successfully");
	    	 
			WebDriver driver = new FirefoxDriver();
	        
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		String URL = prop.getProperty("Url");
		
			driver.manage().window().maximize();
			driver.get(URL);
			System.out.println("Launch gmail URL: ");
	        }
		
		
			WebElement EmailID= driver.findElement(By.xpath(prop.getProperty("UserName")));
			
			String email = prop.getProperty("email");
			EmailID.sendKeys(email);
			
			
			WebElement ClickNext= driver.findElement(By.xpath(prop.getProperty("Nextbtn")));
			ClickNext.click();
			//driver.quit();
	        }
	}
