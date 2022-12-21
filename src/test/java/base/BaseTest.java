package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	public static WebDriver driver;
	
	public FileInputStream fis1;
	
	public FileInputStream fis2;
	
	public Properties configProp=new Properties();
	
	public Properties locatorsProp=new Properties();
	
	
	@BeforeTest
	public void beforeTest() throws IOException
	{
		fis1=new FileInputStream("src\\test\\resources\\properties\\config.properties");
		configProp.load(fis1);
		
		fis2=new FileInputStream("src\\test\\resources\\properties\\locators.properties");
		locatorsProp.load(fis2);
		
		
		
	}
	
	

}
