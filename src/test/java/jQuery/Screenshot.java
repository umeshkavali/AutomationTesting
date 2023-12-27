package jQuery;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot 
{

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		username.clear();
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password.clear();
		password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		WebElement orange_img = driver.findElement(By.xpath("//img[@alt='client brand banner']"));
		
		if(!orange_img.isDisplayed())
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File trg = new File("C:\\Users\\umesh\\OneDrive\\Desktop\\Eclipse Projects\\AutomationTesting\\Screenshots\\Error_Image.png");
			FileUtils.copyFile(src, trg);
			System.out.println("Couldn't find the Orange HRM Logo. Hence captured the Screenshot");
					
		}

	}

}
