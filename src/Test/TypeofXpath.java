package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TypeofXpath
{
		static WebDriver driver;

		public static void main(String[] args) throws Throwable  
	    {
			System.setProperty("webdriver.gecko.driver","D:\\Firefox\\geckodriver.exe");
	    	
	    	   	 
			WebDriver driver = new FirefoxDriver();
			
			//Application Launch	
			driver.get("https://opensource-demo.orangehrmlive.com/");
			System.out.println("Launch app Successfully");
			
			//Login application
			WebElement UserName =driver.findElement(By.xpath("//input[@id='txtUsername']"));
			UserName.sendKeys("Admin");
			WebElement Password =driver.findElement(By.xpath("//input[@name='txtPassword']"));
			Password.sendKeys("admin123");
			WebElement Button =driver.findElement(By.xpath("//input[@class='button']"));
			Button.click();
			System.out.println("Login to the application Successfully");
			
			Thread.sleep(5000);
			
			//Click menu and select drop-down
			WebElement clickmenu =driver.findElement(By.xpath("//a[@class='firstLevelMenu']"));
			clickmenu.click();
			
			Select dropdown =new Select(driver.findElement(By.id("searchSystemUser_userType")));
			Thread.sleep(5000);
			
			WebElement UserProfile =driver.findElement(By.cssSelector("a[id=welcome]"));
			UserProfile.click();
			System.out.println("Select Drop-down successfully");
			
			//Logout application
			WebElement logout = driver.findElement(By.linkText("Logout"));
			logout.click();
			
			System.out.println("Logout Successfully");
	    	} 
}