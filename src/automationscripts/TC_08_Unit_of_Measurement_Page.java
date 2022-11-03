package automationscripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import commonMethods.BaseMethods;

public class TC_08_Unit_of_Measurement_Page  {

	public static void main(String[] args) {
		
		BaseMethods.openBrowser();
		BaseMethods.launchERP();
		BaseMethods.loginERP();
		//click on the Stockcategories_page menu 
		 WebElement stockItems = BaseMethods.driver.findElement(By.id("mi_a_stock_items"));
		Actions actions = new Actions(BaseMethods.driver);
		actions.moveToElement(stockItems).build().perform();
		
		WebElement Ucat = BaseMethods.driver.findElement(By.id("mi_a_unit_of_measurement"));
		actions.moveToElement(Ucat).build().perform();
		Ucat.click();
		//wait = new WebDriverWait(BaseMethods.driver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emPageCaption")));
	
		// put the validation code to check Unitofmeasurement_page is opened or not
		String pcaption=BaseMethods.driver.findElement(By.id("ewPageCaption")).getText();
        if(pcaption.equals("Unit of Measurement")){
			System.out.println("Unit of Measurement_page has displayed, and Test case is Passed");
			} else {
				System.out.println("Unit of Measurement_page is not displayed, and Test case is Failed");
			}
        BaseMethods.driver.close();
	}

}


