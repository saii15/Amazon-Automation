
package E2EProject;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import resources.XLUtil;
import resources.base;

public class Validation extends base {
	public WebDriver driver;
	// to execute testcase parallerly u need to mention this line in evry testcase.
	public static Logger Log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void init() throws IOException {
		driver = initializeDriver();

	}

	@Test(dataProvider = "loginData")
	public void registratin(String item) throws Exception {
		driver.get(prop.getProperty("url2"));
		driver.findElement(By.xpath("//select[@id='searchDropdownBox']")).click();
		Select s = new Select(driver.findElement(By.xpath("//select[@id='searchDropdownBox']")));
		s.selectByIndex(15);
		System.out.println(s.getFirstSelectedOption().getText());
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(item);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath("//input[@id='low-price']")).sendKeys("20000");
		driver.findElement(By.xpath("//input[@id='high-price']")).sendKeys("30000");
		driver.findElement(By.xpath("//input[@class='a-button-input']")).click();

		List<WebElement> elements = driver.findElements(By.tagName("h2"));

		for (WebElement e : elements) {
			String name = e.getText();
			System.out.println(name);

		}

		
		List<WebElement> list_of_products_price = driver.findElements(By.cssSelector(".a-price-whole"));
		
		String product_price;
		int int_product_price;
		
		for(int i=0;i<list_of_products_price.size();i++) 
		{
			product_price = list_of_products_price.get(i).getText();//Iterate and fetch product name
			product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
			int_product_price = Integer.parseInt(product_price);//Convert to Integer
			System.out.println(int_product_price);
			
			if(int_product_price >= 30000 && int_product_price <= 50000)
			{
			System.out.println("Product Not Found for the range between 30000 to 50000");
			}
			
		}

	}

	 @AfterTest
	 public void teardown()
	 {
		 driver.close();
	 }

	@DataProvider(name = "loginData")
	public String[][] getData() throws IOException {
		String path = ".\\dataFiles\\Data.xlsx";
		XLUtil xlutil = new XLUtil(path);

		int totalrows = xlutil.getRowCount("Sheet3");
		int totalcols = xlutil.getCellCount("Sheet3", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0

			{
				loginData[i - 1][j] = xlutil.getCellData("Sheet3", i, j);

			}

		}
		return loginData;
	}

}
