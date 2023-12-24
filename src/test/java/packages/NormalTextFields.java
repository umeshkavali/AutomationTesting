package packages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NormalTextFields 
{

	public static void main(String[] args) throws Exception 
	{
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Name
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Umesh Kavali");
		
		// Email
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("umeshk@outlook.in");
		
		// Phone
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8125794062");
		
		// Address
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("C/o Umesh Kavali, 9-5-14/B, Ramnagar Street, Gadwal-509125");
		
		//Gender
		WebElement male_rd = driver.findElement(By.xpath("//input[@id='male']"));
		WebElement female_rd = driver.findElement(By.xpath("//input[@id='female']"));
		
		if(male_rd.isEnabled())
		{
			male_rd.click();
		}
		
		System.out.println("Selected Male Radio button Successfully");
		
		// Days		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and@type='checkbox']"));
		for(WebElement chkbox:checkboxes)
		{
			chkbox.click();
		}
		
		System.out.println("Slected All the Days Checkboxes");
		
		// Country
		
		WebElement country_drp = driver.findElement(By.xpath("//select[@id='country']"));
		Select drp_country = new Select(country_drp);		
		drp_country.selectByVisibleText("United Kingdom");
		
		// Colors
		WebElement colors = driver.findElement(By.xpath("//select[@class='form-control' and @id='colors']"));
		Select color = new Select(colors);
		color.selectByVisibleText("Green");
		System.out.println("Selected Color from Drop Down");
		
		// Date Field
		
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		String date = "21";
		String month = "July";
		String year = "2021";
		
		
		
		while(true)
		{
			String mon = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(month.equals(mon)&&year.equals(yr))
			{
				break;
			}
			
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}			
			
		}
		
		List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));
		
		for(WebElement dts:all_dates)
		{
			if(dts.getText().equals(date))
			{
				dts.click();
				break;
			}
		}
		
		// Clicking on Orange HRM
		
		driver.findElement(By.linkText("orange HRM")).click();
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> window_ids = driver.getWindowHandles();
		System.out.println("Capturing the Window IDs:"+window_ids);
		
		for(String winId:window_ids)
		{
			String title = driver.getTitle();
			
			if(title.equals("OrangeHRM HR Software | OrangeHRM"))
			{
				driver.findElement(By.linkText("Contact Sales")).click();
			}
			
//			driver.switchTo().defaultContent();
		}
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}
	
	

}
