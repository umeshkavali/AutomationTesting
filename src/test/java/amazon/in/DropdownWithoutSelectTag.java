package amazon.in;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DropdownWithoutSelectTag 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.manage().window().maximize();
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		
		List<WebElement> output_options = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//label[@class='checkbox']"));		
		System.out.println("Getting all the options:"+output_options.size());
		
		//Selecting all the Checkboxes		
		for(WebElement op:output_options)
		{
			if(op.isSelected())
			{
				System.out.println(op.getText());
				op.click();
			}
			
		}
		// Selecting specific Checkbox
		
//		for(int i=0;i<output_options.size();i++)
//		{
//			System.out.println(output_options.get(i).getText());
//			output_options.get(i).click();
//		}
		
		
		
	}

}
