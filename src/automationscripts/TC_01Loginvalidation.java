package automationscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_01Loginvalidation {

public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Selenium softwares\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://webapp.qedgetech.com/login.php");
	driver.manage().window().maximize();
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	driver.findElement(By.id("password")).sendKeys("master");
	driver.findElement(By.id("btnsubmit")).click();
	
    System.out.println(driver.getCurrentUrl());
    String s=driver.getTitle();
    if( s.equals(driver.getTitle()))
    {
    	System.out.println("login succesful");
    }
    else {
    	System.out.println("login failed");
    }
    driver.close();
    
}
}