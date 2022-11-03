package automationscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import commonMethods.BaseMethods;

public class TC_13_Search__StockItems_by_using_Advanced_search {

	public static void main(String[] args) {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock Items menu 
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"mi_a_stock_items\"]/a")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[2]/div[2]/div/a/span")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Category\"]")).click();
		BaseMethods.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Select cat=new Select(BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Category\"]")));
		cat.selectByVisibleText("Chimneys");
		
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnAction\"]")).click();
		
		BaseMethods.driver.close();
	}

}
