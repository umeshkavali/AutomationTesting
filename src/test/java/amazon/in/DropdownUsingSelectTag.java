package amazon.in;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownUsingSelectTag 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		// Select Appliances from Dropdown
		
		WebElement all = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		
		Select items = new Select(all);
		
		items.selectByVisibleText("Appliances");
		
		// Counting the Options from All dropdown
		List<WebElement> options = items.getOptions();
		System.out.println("Counting all the options from All dropdown:"+options.size());
		
		// Capturing all the Options in a Console Window
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
		driver.close();
		
		
		
	}
	
}
