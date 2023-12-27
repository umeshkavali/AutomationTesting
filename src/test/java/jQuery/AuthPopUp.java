package jQuery;

import java.net.SocketException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopUp
{
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String actual_text = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		String expected_text = "Congratulations! You must have the proper credentials.";
		
		if(actual_text.equals(expected_text))
		{
			System.out.println("Pass");
		}
		
		else
		{
			System.out.println("Failed");
		}
		
		Thread.sleep(2000);
		
		
		
		driver.close();

	}

}
