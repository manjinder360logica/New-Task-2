import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class LearnBrowserAlert 
{
	static WebDriver driver;
	
	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\manjinderk\\workspace\\Task2\\Drivers\\chromedriver83.exe");
    	driver = new ChromeDriver();
    	driver.navigate().to("http://www.popuptest.com/");
    	driver.manage().window().maximize();
		driver.findElement(By.xpath("//a [text()='Mouseover PopUp']"));
		//PopupMousehover.click();
		Set<String>windowref = driver.getWindowHandles();
		Iterator<String>itr=windowref.iterator();
		
		String Parentwindow=itr.next();
		driver.switchTo().window(Parentwindow);
		
		
		String title=driver.getTitle();
		
		System.out.println( "Parent page title: " +title);
		String ParentUrl=driver.getCurrentUrl();
		System.out.println("Parent window URL: " +ParentUrl);
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Mouseover PopUp']"))).build().perform();
		
		driver.navigate().to("http://www.popuptest.com/popup10.html");
		Set<String>windowchild = driver.getWindowHandles();
		
		Iterator<String>itr1=windowchild.iterator();
		String Childwindow=itr1.next();
		
		System.out.println("Child window id: " +Childwindow);
		
		driver.switchTo().window(Childwindow);	
		String Childtitle=driver.getTitle();
		System.out.println("Child Window page title: " +Childtitle);
		String ChildUrl=driver.getCurrentUrl();
		System.out.println("Child window URL: " +ChildUrl);
		driver.quit();
	}

}

