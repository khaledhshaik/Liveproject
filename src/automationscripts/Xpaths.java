package automationscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpaths {

public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\Selenium softwares\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://webapp.qedgetech.com/login.php");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("master");
	driver.findElement(By.xpath("//*[@id=\"btnsubmit\"]")).click();
	//driver .findElement(By.id("logout")).click();
	//driver.switchTo().alert().accept();
    System.out.println(driver.getTitle());
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