package automationscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_04VerifyRESET {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium softwares\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://webapp.qedgetech.com/login.php");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"btnreset\"]")).click();
		String uname=driver.findElement(By.xpath("//*[@id=\"username\"]")).getAttribute("value");
		String password=driver.findElement(By.xpath("//*[@id=\"password\"]")).getAttribute("value");
		if(uname.isEmpty()&&password.isEmpty()) {
			System.out.println("RESET is working, Testcase passed");
	} else {
		System.out.println("RESET is not working, Testcase failed");
	}
        driver.close();
}
}