package automationscripts;

import org.openqa.selenium.By;

import commonMethods.BaseMethods;

public class TC_05_Access_To_StockItems {

	public static void main(String[] args) {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the stock Items menu 
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"mi_a_stock_items\"]/a")).click();
		// put the validation code to check stock Items page is opened or not
		String pcaption=BaseMethods.driver.findElement(By.id("ewPageCaption")).getText();
        if(pcaption.equals("Stock Items")){
			System.out.println("Stock Item page has displayed, and Test case is Passed");
			} else {
				System.out.println("Stock Item page is not displayed, and Test case is Failed");
			}
        BaseMethods.driver.close();
	}

}
