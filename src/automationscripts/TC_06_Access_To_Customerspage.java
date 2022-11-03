package automationscripts;

import org.openqa.selenium.By;

import commonMethods.BaseMethods;

public class TC_06_Access_To_Customerspage {

	public static void main(String[] args) {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock Items menu 
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"mi_a_customers\"]/a")).click();
		// put the validation code to check Customerspage is opened or not
		String pcaption=BaseMethods.driver.findElement(By.id("ewPageCaption")).getText();
        if(pcaption.equals("Customers")){
			System.out.println("Customerspage has displayed, and Test case is Passed");
			} else {
				System.out.println("Customerspage is not displayed, and Test case is Failed");
			}
        BaseMethods.driver.close();
	}

}
