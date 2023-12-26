package naukri;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NaukriPhotoUpload 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.naukri.com/");
		
		driver.findElement(By.xpath("//a[@id='login_Layer']")).click();
		
		WebElement username = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")));
		username.sendKeys("umeshk@outlook.in");	
		WebElement password = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter your password']")));
		password.sendKeys("Umesh@062");	

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Complete profile']")).click();
		
		// Validation
		
		String actual_name = driver.findElement(By.xpath("//span[@class='fullname']")).getText();
		String exp_name = "Umesh Kumar";
		
		if(actual_name.equals(exp_name))
		{
			System.out.println("Correct Path");
		}
		
		WebElement add_photo = driver.findElement(By.xpath("//span[normalize-space()='plus']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",add_photo);
		

		WebElement upload = driver.findElement(By.xpath("//input[@id='fileUpload']"));
		upload.sendKeys("C:\\Users\\umesh\\OneDrive\\Desktop\\Imp\\Passphoto.png");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		
		
		// Deletion of Pic
		WebElement exists_photo = driver.findElement(By.xpath("//div[@class='content-wrap']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click();",exists_photo);
		
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Delete photo']")));
		
		driver.findElement(By.xpath("//div[@class='lightbox model_open flipOpen']//button[@class='btn-dark-ot'][normalize-space()='Delete']")).click();
		
	}

}
