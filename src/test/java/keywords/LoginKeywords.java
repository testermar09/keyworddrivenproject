package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginKeywords  {
	WebDriver driver;
	
	public void startBrowser(String browserName)
	{
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		
	}
	
	public void launchApp(String url)
	{
		
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void enterUsername(String locator,String text)
	{
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void enterPassword(String locator,String text)
	{
		driver.findElement(By.xpath(locator)).sendKeys(text);
		
	}
	
	public void clickLogin(String locator)
	{
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void verifyTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	public void closeBrowser()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}

}
