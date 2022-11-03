package automationscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonMethods.BaseMethods;

public class TC_11_Create_Unit_Of_Measurement {

	public static void main(String[] args) throws InterruptedException {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock category menu 
		WebElement stockItems = BaseMethods.driver.findElement(By.id("mi_a_stock_items"));
		Actions actions = new Actions(BaseMethods.driver);
		actions.moveToElement(stockItems).build().perform();
		
		WebElement Ucat = BaseMethods.driver.findElement(By.id("mi_a_unit_of_measurement"));
		actions.moveToElement(Ucat).build().perform();
		Ucat.click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_UOM_ID\"]")).sendKeys("01");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_UOM_Description\"]")).sendKeys("Vaccum Cleaner");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnAction\"]")).click();
		BaseMethods.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		String nwindow=BaseMethods.driver.getWindowHandle();
		BaseMethods.driver.switchTo().window(nwindow);
		Thread.sleep(1000);
	    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
	    String AlertMsg=BaseMethods.driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	    System.out.println(AlertMsg);
	    
	    if(AlertMsg.contains("Add succeeded"))
	    {System.out.println("Test Pass");
	    }
	    else {System.out.println("Test Fail");
	    }
	    BaseMethods.driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	    BaseMethods.driver.close();
	}

}
