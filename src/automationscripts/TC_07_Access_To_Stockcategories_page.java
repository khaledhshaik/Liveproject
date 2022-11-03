package automationscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonMethods.BaseMethods;

public class TC_07_Access_To_Stockcategories_page {

	public static void main(String[] args) {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the Stockcategories_page menu 
		 WebElement stockItems = BaseMethods.driver.findElement(By.id("mi_a_stock_items"));
		Actions actions = new Actions(BaseMethods.driver);
		actions.moveToElement(stockItems).build().perform();
		
		WebElement stockCat = BaseMethods.driver.findElement(By.id("mi_a_stock_categories"));
		actions.moveToElement(stockCat).build().perform(); 
		stockCat.click();
		
		// put the validation code to check Stockcategories_page is opened or not
		String pcaption=BaseMethods.driver.findElement(By.id("ewPageCaption")).getText();
        if(pcaption.equals("Stock Categories")){
			System.out.println("Stockcategories_page has displayed, and Test case is Passed");
			} else {
				System.out.println("Stockcategories_page is not displayed, and Test case is Failed");
			}
        BaseMethods.driver.close();
	}

}
