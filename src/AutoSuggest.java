import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
 
public class AutoSuggest 
{
 
	@Test(description="Auto Suggest")
	public void selectValues()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\manjinderk\\workspace\\Task2\\Drivers\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://in.yahoo.com/?p=us");
		driver.findElement(By.xpath("//input[@name='p']")).sendKeys("Selenium");
		
		/**
		 * Example for Visibility of Elements located by
		 */
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		System.out.println("Auto Suggest List ::" + list.size());
		
		for(int i = 0 ;i< list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().equals("selenium interview questions"))
			{
				list.get(i).click();
				//System.out.println(list.get(i).getText());
				break;
			}
			WebElement Guru99= driver.findElement(By.xpath("//span[text()='www.guru99.com/top-100-']"));
			Guru99.click();
		}
		
	}
	
}
