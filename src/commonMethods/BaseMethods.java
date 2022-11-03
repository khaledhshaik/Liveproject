package commonMethods;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BaseMethods {
	
	public static WebDriver driver;
	
	//Open Browser
	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Selenium softwares\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//To Launch the ERP Application
	public static void launchERP() {
		driver.get("http://webapp.qedgetech.com/login.php");
		driver.manage().window().maximize();
	}
	
	public void launchERP(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	//Login to the Application
	public static void loginERP() {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		String pName = driver.findElement(By.id("ewPageCaption")).getText();
		Assert.assertEquals(pName, "Dashboard");
	}
	
	public static void loginERP(String uname, String pass) {
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("btnsubmit")).click();
		String pName = driver.findElement(By.id("ewPageCaption")).getText();
		Assert.assertEquals(pName, "Dashboard");
	}
	
	//Logout ERP
		public static void logoutERP() {
			driver.findElement(By.id("mi_logout")).click();
			//validate Login button existance
			
			if(driver.findElement(By.id("btnsubmit")).isEnabled()) {
				System.out.println("Logout is success, and Test case is Passed");
			} else {
				System.out.println("Logout is failed, and Test case is Failed");
			}
		}
	
	//close Application
	public void closeApp() {
		driver.close();
	}

	public void loginParam(String uname, String pass) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("btnsubmit")).click();
		String pName = driver.findElement(By.id("ewPageCaption")).getText();
		Assert.assertEquals(pName, "Dashboard");
	}

	public static void AccessToStockItemsPage() {
		//click on the stock Items menu 
		  driver.findElement(By.xpath("//li[@id='mi_a_stock_items']")).click();
		// put the validation code to check stock Items page is opened or not
		 String pcaption = driver.findElement(By.id("ewPageCaption")).getText();
		 if(pcaption.equals("Stock Items")){
				System.out.println("Stock Item page has displayed, and Test case is Passed");
				} else {
					System.out.println("Stock Item page is not displayed, and Test case is Failed");
				}
	}
	
	public static void AccessToCustomersPage() {
		  driver.findElement(By.id("mi_a_customers")).click();
		  String pageName = driver.findElement(By.id("ewPageCaption")).getText();
		  Assert.assertTrue(pageName.equals("Customers"));
	}
	
	public static void AccessToStockCategoriesPage() {
	      WebElement stockItems = driver.findElement(By.id("mi_a_stock_items"));
		  Actions actions = new Actions(driver);
		  actions.moveToElement(stockItems).build().perform();
			
		  WebElement stockCat = driver.findElement(By.id("mi_a_stock_categories"));
		  actions.moveToElement(stockCat).build().perform(); 
	      stockCat.click();
			  
		  String pageName = driver.findElement(By.id("ewPageCaption")).getText();
		  Assert.assertTrue(pageName.equals("Stock Categories"));
	}
	
	public static void AccessToUOMPage() {
	     WebElement stockItems = driver.findElement(By.id("mi_a_stock_items"));
			
			Actions actions = new Actions(driver);
			actions.moveToElement(stockItems).build().perform();
			
			WebElement uom = driver.findElement(By.id("mi_a_unit_of_measurement"));
			actions.moveToElement(uom).build().perform();
			uom.click();
			
			String pageName = driver.findElement(By.id("ewPageCaption")).getText();
			Assert.assertTrue(pageName.equals("Unit of Measurement"));
	}
	
	public void addStockItem() {
		
		WebElement addStock = driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]"));
		addStock.click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		Select category = new Select(driver.findElement(By.id("x_Category")));
		category.selectByVisibleText("mobiles");
		Select supplierNumber = new Select(driver.findElement(By.id("x_Supplier_Number")));
		supplierNumber.selectByVisibleText("First Supplier");
		WebElement stockName = driver.findElement(By.xpath("//input[@id='x_Stock_Name']"));
		stockName.sendKeys("Samsung Galaxy S21");
		Select uom = new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
		uom.selectByVisibleText("Units");
		WebElement purchasePrice = driver.findElement(By.xpath("//input[@id='x_Purchasing_Price']"));
		purchasePrice.sendKeys("100000");
		WebElement sellingPrice = driver.findElement(By.xpath("//input[@id='x_Selling_Price']"));
		sellingPrice.sendKeys("125000");
		WebElement notes = driver.findElement(By.xpath("//input[@id='x_Notes']"));
		notes.sendKeys("Samsung Galaxy S21");
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		String alertWindow = driver.getWindowHandle();	
		driver.switchTo().window(alertWindow);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		WebElement confirm = driver.findElement(By.xpath("//button[@class='ajs-button btn btn-primary']"));
		confirm.click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	}
	
	public static void CreateStockitem() throws InterruptedException {
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"mi_a_stock_items\"]/a")).click();
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	BaseMethods.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	Select s=new Select(BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Category\"]")));
	s.selectByVisibleText("Chimneys");
	 //Thread.sleep(1000);
	Select s1=new Select(BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Supplier_Number\"]")));
	s1.selectByVisibleText("First Supplier");
	//Thread.sleep(1000);
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Stock_Name\"]")).sendKeys("Elico Chimney");
	
	Select s2=new Select(BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Unit_Of_Measurement\"]")));
	s2.selectByVisibleText("Units");
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Purchasing_Price\"]")).clear();
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Purchasing_Price\"]")).sendKeys("7500");
	Thread.sleep(1000);
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Selling_Price\"]")).clear();
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Selling_Price\"]")).sendKeys("8000");
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Notes\"]")).sendKeys("New");
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnAction\"]")).click();
	String nwindow=BaseMethods.driver.getWindowHandle();
	BaseMethods.driver.switchTo().window(nwindow);
	Thread.sleep(1000);
    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
    String AlertMsg=BaseMethods.driver.findElement(By.xpath("//div[@class=\"alert alert-success ewSuccess\"]")).getText();
    System.out.println(AlertMsg);
    if(AlertMsg.contains("Add succeeded"))
    {System.out.println("Test Pass");
    }
    else {System.out.println("Test Fail");
    }
    
	}
	
	
	public static void CreateStockcat() throws InterruptedException {
		WebElement stockItems = BaseMethods.driver.findElement(By.id("mi_a_stock_items"));
		Actions actions = new Actions(BaseMethods.driver);
		actions.moveToElement(stockItems).build().perform();
		
		WebElement stockCat = BaseMethods.driver.findElement(By.id("mi_a_stock_categories"));
		actions.moveToElement(stockCat).build().perform(); 
		stockCat.click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_Category_Name\"]")).sendKeys("Chimneys kitchen");
		BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnAction\"]")).click();
		BaseMethods.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		String nwindow=BaseMethods.driver.getWindowHandle();
		BaseMethods.driver.switchTo().window(nwindow);
		Thread.sleep(1000);
	    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
	    String AlertMsg=BaseMethods.driver.findElement(By.xpath("//div[@class=\"alert alert-success ewSuccess\"]")).getText();
	    System.out.println(AlertMsg);
	    //String nwindow2=BaseMethods.driver.getWindowHandle();
		//BaseMethods.driver.switchTo().window(nwindow2);
	    if(AlertMsg.contains("Add succeeded"))
	    {System.out.println("Test Pass");
	    }
	    else {System.out.println("Test Fail");
	    }
	    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
    
	}
	
	
	public static void CreateUOM() throws InterruptedException {
	WebElement stockItems = BaseMethods.driver.findElement(By.id("mi_a_stock_items"));
	Actions actions = new Actions(BaseMethods.driver);
	actions.moveToElement(stockItems).build().perform();
	
	WebElement Ucat = BaseMethods.driver.findElement(By.id("mi_a_unit_of_measurement"));
	actions.moveToElement(Ucat).build().perform();
	Ucat.click();
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"ewContentColumn\"]/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_UOM_ID\"]")).sendKeys("05");
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"x_UOM_Description\"]")).sendKeys("Vaccum Cleaner");
	BaseMethods.driver.findElement(By.xpath("//*[@id=\"btnAction\"]")).click();
	BaseMethods.driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	
	String nwindow=BaseMethods.driver.getWindowHandle();
	BaseMethods.driver.switchTo().window(nwindow);
	Thread.sleep(1000);
    BaseMethods.driver.findElement(By.xpath("//button[@class=\"ajs-button btn btn-primary\"]")).click();
    String AlertMsg=BaseMethods.driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
    System.out.println(AlertMsg);
    
    if(AlertMsg.contains("Add succeeded"))
    {System.out.println("Test Pass");
    }
    else {System.out.println("Test Fail");
    } 
    BaseMethods.driver.findElement(By.xpath("/html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	}
	
}