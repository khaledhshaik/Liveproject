package testNGScripts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.BaseMethods;


public class HomePageModule {
	
  @BeforeMethod
  public void OpenERPApp() {
	  BaseMethods.openBrowser();
	  BaseMethods.launchERP();
	  BaseMethods.loginERP();
  }
  
  @AfterMethod
  public void CloseERPApp() {
	  BaseMethods.driver.close();
  }
  
  @Test(priority=1, enabled=true)
  public  void stockitems() {
	  BaseMethods.AccessToStockItemsPage();
  }
  @Test(priority=2)
  public void customerpage() {
	  BaseMethods.AccessToCustomersPage();
  }
  @Test(priority=3)
  public void Stockcategory() {
	  BaseMethods.AccessToStockCategoriesPage();
  }
  @Test(priority=4)
  public void UnitofMeasurement() {
	  BaseMethods.AccessToUOMPage();
  }
  
 
	}
 