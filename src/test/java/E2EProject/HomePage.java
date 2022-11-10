package E2EProject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import resources.XLUtil;
import resources.base;

 public class HomePage extends base 
 {
	 public WebDriver driver; //to execute testcase parallerly u need to mention this line in evry testcase.
	 public static Logger Log =LogManager.getLogger(base.class.getName());
		
	 @BeforeTest
		public void init() throws IOException
		{
		 driver=initializeDriver();
		}
	 
	
	
	 @Test(dataProvider="searchData")
	public void search(String name)
	{
		driver.get(prop.getProperty("url"));
		Log.info("Google page is opening on the browser");
		driver.findElement(By.cssSelector("[name='q']")).sendKeys(name);
		Log.info("Searching for an amazon");
		List<WebElement> products = driver.findElements(By.xpath("//ul/li"));

	    for(WebElement product:products) {

	        System.out.println(product.getText()); 
	        Log.info("Printing list of search results ");
	    }
		
		
	}
	
	@DataProvider(name="searchData")
	public String [][] getData() throws IOException
	{
		String path=".\\dataFiles\\Data.xlsx";
		XLUtil xlutil=new XLUtil(path);
		
		int totalrows=xlutil.getRowCount("Sheet2");
		int totalcols=xlutil.getCellCount("Sheet2",1);	
				
		String Data[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				Data[i-1][j]=xlutil.getCellData("Sheet2", i, j);
			}
				
		}
		
		return Data;
	}
	
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	} 
	
	
	
	
}
