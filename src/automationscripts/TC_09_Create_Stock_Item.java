package automationscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import commonMethods.BaseMethods;

public class TC_09_Create_Stock_Item {

	public static void main(String[] args) throws InterruptedException {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock Items menu 
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"mi_a_stock_items\"]/a")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		BaseMethods.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		Select s=new Select(BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Category\"]")));
		s.selectByVisibleText("Chimneys");
		 //Thread.sleep(1000);
		Select s1=new Select(BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Supplier_Number\"]")));
		s1.selectByVisibleText("First Supplier");
		//Thread.sleep(1000);
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Stock_Name\"]")).sendKeys("Elico Chimney");
		
		Select s2=new Select(BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Unit_Of_Measurement\"]")));
		s2.selectByVisibleText("Units");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Purchasing_Price\"]")).clear();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Purchasing_Price\"]")).sendKeys("7500");
		Thread.sleep(1000);
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Selling_Price\"]")).clear();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Selling_Price\"]")).sendKeys("8000");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Notes\"]")).sendKeys("New");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnAction\"]")).click();
		String nwindow=BaseMethods.driver.getWindowHandle();
		BaseMethods.driver.switchTo().window(nwindow);
		Thread.sleep(1000);
	    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
	    String AlertMsg=BaseMethods.driver.findElement(By.xpath("//div[@class=\"alert alert-success ewSuccess\"]")).getText();
	    System.out.println(AlertMsg);
	    if(AlertMsg.contains("Add succeeded"))
	    {System.out.println("Test Pass");
	    }
	    else {System.out.println("Test Fail");
	    }
	    BaseMethods.driver.close();
		///html/body/div[18]/div[2]/div/div[4]/div[2]/button[1]
	    ///html/body/div[19]/div[2]/div/div[4]/div[2]/button[1]
	}

}
