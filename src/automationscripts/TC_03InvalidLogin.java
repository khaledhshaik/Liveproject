package automationscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_03InvalidLogin {

public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Selenium softwares\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://webapp.qedgetech.com/login.php");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("username")).sendKeys("adminn");
	driver.findElement(By.id("password")).sendKeys("masterr");
	driver.findElement(By.id("btnsubmit")).click();
	//driver.findElement(By.xpath("/html/body/div[18]/div[2]/div/div[3]/div/div"));
    
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	String alertWindow = driver.getWindowHandle();	
	driver.switchTo().window(alertWindow);
	
	String actResult = driver.findElement(By.xpath("//div[@class='alert alert-danger ewError']")).getText();
	System.out.println("Actual Result is : " + actResult);
	if(actResult.contains("Incorrect")) 
   {
   	System.out.println("Invalid Login Test succesful");
   }
   else {
   	System.out.println("Invalid Login Test failed");
   }
   driver.close();
  ;
}
}