package tabs;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tabs {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Tabs
		WebElement wikipedia_text = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		wikipedia_text.clear();
		wikipedia_text.sendKeys("Selenium");
				
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> results = driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div"));
		System.out.println("Counting the total number of Links:"+results.size());
		
		
		// Normal For Loop
		for(int i=0;i<results.size();i++)
		{
			results.get(i).click();
			continue;
		}
		
		// Enhanced For Loop
//		for(WebElement res:results)
//		{
//			res.click();
//			continue;
//		}
		
		

	}

}
