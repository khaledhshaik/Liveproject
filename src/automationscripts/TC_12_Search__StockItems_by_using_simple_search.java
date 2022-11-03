package automationscripts;

import org.openqa.selenium.By;
import commonMethods.BaseMethods;

public class TC_12_Search__StockItems_by_using_simple_search {

	public static void main(String[] args) {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock Items menu 
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"mi_a_stock_items\"]/a")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[2]/div[2]/div/button/span")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"psearch\"]")).sendKeys("Chimneys");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnsubmit\"]")).click();
		
		BaseMethods.driver.close();
	}

}
