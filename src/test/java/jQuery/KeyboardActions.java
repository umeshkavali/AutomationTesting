package jQuery;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions 
{
	public static WebDriver driver;

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement field_1 = driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement field_2 = driver.findElement(By.xpath("//input[@id='field2']"));
		
		Actions action = new Actions(driver);
		
		field_1.clear();
		Thread.sleep(2000);
		field_1.sendKeys("Welcome Umesh");
		
		// Copy the Text
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		// Paste the Text in field2
		action.keyDown(Keys.TAB).keyUp(Keys.UP).perform();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		
		action.doubleClick().build().perform();
		
		if(field_1.getText().equals(field_2))
		{
			System.out.println("Pass");
		}
		
		

	}

}
