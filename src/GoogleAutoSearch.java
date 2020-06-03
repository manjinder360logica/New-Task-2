import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAutoSearch {
static WebDriver driver;

	public static void main(String[] args)  
    {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\manjinderk\\workspace\\Task2\\Drivers\\chromedriver83.exe");
    	driver = new ChromeDriver();
    	System.out.println("Launch app Successfully");
    	 
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement googletextbox = driver.findElement(By.xpath("//input[@name='q']"));
		googletextbox.sendKeys("Selenium");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int i = 0 ;i< list.size();i++)
		{
			
			
			if(list.get(i).getText().equals("selenium interview questions"))
			
			{
				
				list.get(i).click();
				//System.out.println(list.get(i).getText());
				break;
			}
			System.out.println(list.get(i).getText());
		}
		WebElement Guru99= driver.findElement(By.xpath("(//h3[@class='LC20lb DKV0Md'])[3]"));
		Guru99.click();
    }		
}