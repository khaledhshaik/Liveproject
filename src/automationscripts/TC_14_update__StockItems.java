package automationscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import commonMethods.BaseMethods;

public class TC_14_update__StockItems {

	public static void main(String[] args) {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock Items menu 
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"mi_a_stock_items\"]/a")).click();
		
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"key\"]")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[2]/div/button/span")).click();
		Actions action = new Actions(BaseMethods.driver);
		action.keyDown(Keys.CONTROL).click().build().perform();
		
	
		//BaseMethods.driver.close();
	}

}
