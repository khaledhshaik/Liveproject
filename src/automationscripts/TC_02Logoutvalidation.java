package automationscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_02Logoutvalidation {

public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\Selenium softwares\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://webapp.qedgetech.com/login.php");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("master");
	driver.findElement(By.id("btnsubmit")).click();
	driver .findElement(By.id("logout")).click();
	driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
    System.out.println(driver.getCurrentUrl());
    String s=driver.getCurrentUrl();
    if(s.equals(driver.getCurrentUrl()))
    {System.out.println("logout succesful");
    }
    else {System.out.println("logout failed");
    }
   driver.close();    
}
}   