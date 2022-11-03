package automationscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonMethods.BaseMethods;

public class TC_10_Create_Stock_Category {

	public static void main(String[] args) throws InterruptedException {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock category menu 
		WebElement stockItems = BaseMethods.driver.findElement(By.id("mi_a_stock_items"));
		Actions actions = new Actions(BaseMethods.driver);
		actions.moveToElement(stockItems).build().perform();
		
		WebElement stockCat = BaseMethods.driver.findElement(By.id("mi_a_stock_categories"));
		actions.moveToElement(stockCat).build().perform(); 
		stockCat.click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Category_Name\"]")).sendKeys("Chimneys kitchen");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnAction\"]")).click();
		BaseMethods.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		String nwindow=BaseMethods.driver.getWindowHandle();
		BaseMethods.driver.switchTo().window(nwindow);
		Thread.sleep(1000);
	    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
	    String AlertMsg=BaseMethods.driver.findElement(By.xpath("//div[@class=\"alert alert-success ewSuccess\"]")).getText();
	    System.out.println(AlertMsg);
	    //String nwindow2=BaseMethods.driver.getWindowHandle();
		//BaseMethods.driver.switchTo().window(nwindow2);
	    if(AlertMsg.contains("Add succeeded"))
	    {System.out.println("Test Pass");
	    }
	    else {System.out.println("Test Fail");
	    }
	    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
	    BaseMethods.driver.close();
	}

}
