package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.LoginKeywords;

public class ValidateLogin extends BaseTest {
	
	
	FileInputStream fis;
	
	XSSFWorkbook wb;
	
	XSSFSheet ws;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		
		fis=new FileInputStream("src\\test\\resources\\testdata\\excels\\LoginKeywordsTestData.xlsx");
		
		wb=new XSSFWorkbook(fis);
		
		ws=wb.getSheet("Sheet1");
	}
	
	
	@Test(dataProvider = "getData")
	public void validateLoginTest(String username,String password,String expTitle)
	{
		Iterator<Row> rows=ws.rowIterator();
		
		rows.next();
		
		LoginKeywords keys=new LoginKeywords();
		
		Row row=null;
		while(rows.hasNext())
		{
			
			row=rows.next();
			
			String action=row.getCell(4).getStringCellValue();
			
			if(action.equals("startBrowser"))
			{
				keys.startBrowser(configProp.getProperty("browser"));
			}
			else if(action.equals("launchApp"))
			{
				keys.launchApp(configProp.getProperty("url"));
			}
			
			else if(action.equals("enterUsername"))
			{
				keys.enterUsername(locatorsProp.getProperty("username_text"),username);
			}
			else if(action.equals("enterPassword"))
			{
				keys.enterPassword(locatorsProp.getProperty("password_text"),password);
			}
			else if(action.equals("clickLogin"))
			{
				keys.clickLogin(locatorsProp.getProperty("login_button"));
			}
			else if(action.equals("verifyTitle"))
			{
				keys.verifyTitle(expTitle);
			}
			//closeBrowser
			else if(action.equals("closeBrowser"))
			{
				keys.closeBrowser();
			}
		}
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		FileInputStream fis= new FileInputStream("src\\test\\resources\\testdata\\excels\\AdactinTestData.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet ws=wb.getSheet("Sheet1");
		
		int noOfRows=ws.getPhysicalNumberOfRows()-1;
		
		int noOfCells=ws.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] data=new Object[noOfRows][noOfCells];
		
		for(int i=0;i<noOfRows;i++)
		{
			for(int j=0;j<noOfCells;j++)
			{
				data[i][j]=ws.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		
		
		return data;
		
	}


}
