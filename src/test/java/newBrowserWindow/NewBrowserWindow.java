package newBrowserWindow;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewBrowserWindow 
{

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		try
		{
			driver.get("https://testautomationpractice.blogspot.com/");
			
				// New Browser Window
				driver.findElement(By.xpath("//button[normalize-space()='New Browser Window']")).click();
				
				Set<String> window_ids = driver.getWindowHandles();
				for(String winId:window_ids)
				{
					String title = driver.switchTo().window(winId).getTitle();
					
					if(title.equals("Your Store"))
					{
						WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
						WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
						
						Thread.sleep(2000);
						
						Actions action = new Actions(driver);
						action.moveToElement(desktop).moveToElement(mac).click().build().perform();
						
						Thread.sleep(2000);
						
					}
				}
				
				for(String winId:window_ids)
				{
					String title = driver.switchTo().window(winId).getTitle();
					
					if(title.equals("Mac"))
					{
						driver.close();			
					}
					
				}
				
				for(String winId:window_ids)
				{
//					driver.switchTo().defaultContent();
					String title = driver.switchTo().window(winId).getTitle();
					
					if(title.equals("Automation Testing Practice"))
					{
						// JS Alert		
						driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
						Thread.sleep(3000);
						Alert alert = driver.switchTo().alert();
						alert.accept();
						System.out.println("Clicked on Alert link Successfully");	
					}
					
					
				}		
		}
		
		
			
			 catch (NoSuchWindowException e) 
			{
				
				e.printStackTrace();
			}
		
		//
		
		
		
		driver.quit();
		


	}

}
