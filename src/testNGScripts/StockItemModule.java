package testNGScripts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonMethods.BaseMethods;


public class StockItemModule {
	
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
  public  void CreateStockItem() throws InterruptedException {
	  BaseMethods.CreateStockitem();
  }
  @Test(priority=2)
  public  void CreateStockcat() throws InterruptedException {
	  BaseMethods.CreateStockcat();
  }
  @Test(priority=3)
  public  void CreateUOM() throws InterruptedException {
	  BaseMethods.CreateUOM();
  }
  
  
 
	}
 